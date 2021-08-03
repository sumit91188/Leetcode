package explore.hashTable;

import java.util.HashMap;

/**
 * @author Sumit Deo
 * @Date 7/27/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/4sum-ii/
 */
public class Sum4 {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2};
        int[] nums2 = new int[] {-2,-1};
        int[] nums3 = new int[] {-1,2};
        int[] nums4 = new int[] {0,2};

        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(nums1, nums2, nums3, nums4));
    }

    private static class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int count = 0;
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num1 : nums1) {
                for (int num2 : nums2) {
                    map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
                }
            }

            for (int num3 : nums3) {
                for (int num4 : nums4) {
                    count += map.getOrDefault(- (num3 + num4), 0);
                }
            }

            return count;
        }
    }
}
