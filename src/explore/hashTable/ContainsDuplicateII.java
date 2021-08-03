package explore.hashTable;

import java.util.HashMap;

/**
 * @author Sumit Deo
 * @Date 7/25/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1121/
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1,2,3};
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }

    private static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    if (Math.abs(map.get(nums[i]) - i) <= k) {
                        return true;
                    }
                }
                map.put(nums[i], i);
            }
            return false;
        }
    }
}
