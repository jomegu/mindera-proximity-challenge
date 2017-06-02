/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jomegu.mindera.proximitychallenge;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jomegu
 */
public class ProximityGroupingTest {

    public ProximityGroupingTest() {
    }

    /**
     * Test of groupInt method, of class ProximityGrouping. Verifies that, even
     * if all the provided numbers are equal, there are no empty groups.
     */
    @org.junit.Test
    public void testGroupIntEmptyGroups() {
        System.out.println("groupInt - no empty groups test");
        int[] numbers = {1, 1, 1};
        int nGroups = 2;
        int[][] groups = ProximityGrouping.groupInt(numbers, nGroups);
        boolean noEmpty = true;
        for (int[] group : groups) {
            if (group == null || group.length == 0) {
                noEmpty = false;
                break;
            }
        }
        assertTrue(noEmpty);
    }

    /**
     * Test of groupInt method, of class ProximityGrouping. Different strategies
     * may result in different groups, but no group should intersect another,
     * unless in situations where empty groups must be avoided, for example
     * [1,1,1] -> [[1,1],[1]] should be accepted but [1,2,3,4] -> [[1,3][2,4]]
     * should not
     */
    @org.junit.Test
    public void testGroupIntGroupsIntersection() {
        System.out.println("groupInt - groups intersection test");
        int[] numbers = {1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        int nGroups = 8;
        int[][] groups = ProximityGrouping.groupInt(numbers, nGroups);
        boolean noIntersection = true;
        for (int[] group : groups) {
            int min = Arrays.stream(group).min().getAsInt();
            int max = Arrays.stream(group).max().getAsInt();
            for (int[] other_group : groups) {
                int other_min = Arrays.stream(other_group).min().getAsInt();
                int other_max = Arrays.stream(other_group).max().getAsInt();
                //if there is intersection and it's not the same group
                if (((min <= other_min && max > other_min) || (max >= other_max && min < other_max)) && group != other_group) {
                    noIntersection = false;
                    break;
                }
            }
            if (!noIntersection) {
                break;
            }
        }
        assertTrue(noIntersection);
    }

    /**
     * The following tests check if the input is correctly validated.
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testGroupIntNullArray() {
        System.out.println("groupInt - null array");
        int[] numbers = null;
        int nGroups = 1;
        ProximityGrouping.groupInt(numbers, nGroups);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testGroupIntEmptyArray() {
        System.out.println("groupInt - empty array");
        int[] numbers = new int[0];
        int nGroups = 1;
        ProximityGrouping.groupInt(numbers, nGroups);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testGroupIntLessThanOneGroup() {
        System.out.println("groupInt - 0 groups");
        int[] numbers = {1};
        int nGroups = 0;
        ProximityGrouping.groupInt(numbers, nGroups);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testGroupIntLessNumbersThanGroups() {
        System.out.println("groupInt - less numbers than groups");
        int[] numbers = {1};
        int nGroups = 2;
        ProximityGrouping.groupInt(numbers, nGroups);
    }

}
