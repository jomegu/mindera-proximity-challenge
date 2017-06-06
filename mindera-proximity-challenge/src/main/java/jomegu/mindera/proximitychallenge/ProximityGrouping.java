
package jomegu.mindera.proximitychallenge;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.array.TIntArrayList;
import java.util.Arrays;


/**
 *
 * @author jomegu
 */
public class ProximityGrouping {
    
    /**
     *
     * @param numbers An integer array with the numbers to be grouped
     * @param nGroups The desired number of groups
     * @return An array of integer arrays representing the groups
     */
    public static int[][] groupInt(int[] numbers, int nGroups){
        if(numbers == null || numbers.length == 0){
            throw new IllegalArgumentException("No numbers provided.");
        }
        if(nGroups < 1){
            throw new IllegalArgumentException("There must be at least one group.");
        }
        if(numbers.length < nGroups){
            throw new IllegalArgumentException("There can't be more groups than numbers.");
        }
        
        int[][] finalGroups = new int[nGroups][];
        
        if(numbers.length == nGroups){ //in this case each group will only have one number
            for(int i = 0; i < finalGroups.length; i++){
                finalGroups[i] = new int[]{numbers[i]}; //create an array of each number and add it to the array of the groups
            }
            return finalGroups;
        }
        
        TIntArrayList[] groups; //array of the groups
        TIntArrayList[] old_groups; //previous array of the groups
        boolean changed = true; //if the groups changed or not in caomparison to the previous iteration
        
        float[] centers = selectCentersMostDistant(numbers, nGroups); //contains the center of each group
        groups = assignGroups(numbers, centers);
        
        while(changed){ //while the groups are changed
            centers = calcCenters(groups);  //calculate the new centers
            old_groups = groups; //save the current instance of groups
            groups = assignGroups(numbers, centers); //assign the numbers into the new groups
            changed = !Arrays.deepEquals(groups, old_groups); //verify if the groups were changed
        }
        
        for(int i=0; i<finalGroups.length; i++){
            finalGroups[i] = groups[i].toArray();
        }
        return finalGroups;
    }
    
    /*Selects the first n elements as the initial centers of the groups
    Used in early versions. Has some problems, for example it would cause [4,4,5,6] -> [[4],[4],[5,6]]
    At this point it has already been verified if the length of numbers is not less than n
    */
    private static float[] selectCentersFirstElements(int[] numbers, int n){
        float[] centers = new float[n];
        for(int i=0; i<n; i++){
            centers[i] = numbers[i];
        }
        return centers;
    }
    
    /*After selecting one center, the next ones will be selected to be the most distant from the nearest center
    At this point it has already been verified if the length of numbers is not less than n
    */
    private static float[] selectCentersMostDistant(int[] numbers, int n){
        float[] centers = new float[n];
        centers[0] = numbers[0];
        
        for(int i=1; i<n; i++){ //for all the centers that need to be created
            int center = 0;
            int dist = -1;
            for(int number : numbers){ //for every number
                int mindist = Integer.MAX_VALUE;
                for(int j=0; j<i; j++){  //find the nearest center of the number (distance)
                    if(Math.abs(number - centers[j]) < mindist)
                        mindist = Math.abs(number - (int)centers[j]);
                }
                //if the distance of this number to the nearest center is higher than the previously found
                //this center is a canditate to be the next selected center
                if(mindist > dist){ 
                    dist = mindist;
                    center = number;
                }
            }
            centers[i] = center;
        }
        
        return centers;
    }
    
    //Assigns the numbers to the groups where the distance to the center is minimal
    private static TIntArrayList[] assignGroups(int[] numbers, float[] centers){
        TIntArrayList[] groups = new TIntArrayList[centers.length];
        for(int number : numbers){
            float min_distance = Float.MAX_VALUE; //minimum distance of the number to a center
            int index = -1; //array index of that center
            
            //Find which group the number should be assigned into
            for(int i=0; i<centers.length; i++){
                float dist = Math.abs(number - centers[i]);
                
                //If there are multiple groups with the same center, we want to make sure every one of them gets at least a number
                if(dist == min_distance && groups[i] == null){
                    index = i;
                }
                else if(dist < min_distance){
                    min_distance = dist;
                    index = i;
                }
            }
            
            //If this is the first number to be assigned into this groups, a new instance of TIntArrayList must be created
            if(groups[index] == null){
                groups[index] = new TIntArrayList();
            }
            
            //Assign the number into the group
            groups[index].add(number);
        }
        return groups;
    }

    //Calculates the mean of each group to be used as the centers
    private static float[] calcCenters(TIntArrayList[] groups) {
        float[] centers = new float[groups.length];
        for(int i=0; i<groups.length; i++){
            long sum = 0;
            TIntIterator iterator = groups[i].iterator();
            while(iterator.hasNext()){
                sum += iterator.next();
            }
            centers[i] = (float)sum / groups[i].size();
        }
        return centers;
    }
}
