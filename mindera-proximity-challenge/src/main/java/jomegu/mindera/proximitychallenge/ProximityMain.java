package jomegu.mindera.proximitychallenge;

import java.util.Arrays;
import static jomegu.mindera.proximitychallenge.ProximityGrouping.groupInt;

/**
 *
 * @author jomegu
 */
public class ProximityMain {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar mindera-proximity-challenge.jar <number_array> <number_of_groups>");
            return;
        }

        int[] numbers;
        int groups;
        try {
            numbers = Arrays.stream(args[0].substring(1, args[0].length() - 1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            groups = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("Usage: java -jar mindera-proximity-challenge.jar <number_array> <number_of_groups>"
                    + "\nExample: java -jar mindera-proximity-challenge.jar [12,13,22,23] 2");
            return;
        }
        try {
            int[][] grouped = groupInt(numbers, groups);
            System.out.println(Arrays.deepToString(grouped));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
