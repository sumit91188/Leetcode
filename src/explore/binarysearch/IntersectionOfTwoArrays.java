package explore.binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sumit Deo
 * @Date 6/29/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1034/
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,2,1,4};
        int[] nums2 = new int[] {2,2,4,3};

        Solution solution = new Solution();
        int[] intersectionArray = solution.intersection(nums1, nums2);

        for (int i: intersectionArray) {
            System.out.print(i + " ");
        }
    }

    private static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }

            HashSet<Integer> set2 = new HashSet<>();
            for (int num : nums2) {
                set2.add(num);
            }

            if (set1.size() >= set2.size()) {
                return getIntersection(set1, set2);
            }
            return getIntersection(set2, set1);
        }

        private int[] getIntersection(HashSet<Integer> set1, HashSet<Integer> set2) {
            int[] intersectionArray = new int[set1.size()];
            int index = 0;
            for (int num : set2) {
                if (set1.contains(num)) {
                    intersectionArray[index++] = num;
                }
            }

            return Arrays.copyOf(intersectionArray, index);
        }
    }
}
