package explore.hashTable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Sumit Deo
 * @Date 7/25/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1178/
 */
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,3,4};
        int[] nums2 = new int[]{1,2,2,2,4};

        Solution solution = new Solution();
        int[] nums = solution.intersect(nums1, nums2);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length < nums2.length) {
                return intersect(nums2, nums1);
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int k = 0;

            for (int num : nums2) {
                int count = map.getOrDefault(num, 0);
                if (count > 0) {
                    nums1[k++] = num;
                    map.put(num, count - 1);
                }
            }

            return Arrays.copyOfRange(nums1, 0, k);
        }
    }
}
