package explore.binarysearch;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Sumit Deo
 * @Date 6/29/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1029/
 */
public class IntersectionOfTwoArraysII {
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
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int[] result = new int[nums1.length + nums2.length];

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i++;
                    continue;
                }
                else if (nums1[i] > nums2[j]) {
                    j++;
                    continue;
                }
                else {
                    result[k++] = nums1[i++];
                    j++;
                }
            }
            return Arrays.copyOf(result, k);
        }
    }
}
