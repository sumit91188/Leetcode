package explore.binarySearchTree;

import java.util.TreeSet;

/**
 * @author Sumit Deo
 * @Date 7/13/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1013/
 */
public class ContainsDuplicateIII {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,9,1,5,9};
        int k = 2;
        int t = 3;

        Solution solution = new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
    }

    private static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Integer> set = new TreeSet<>();

            for (int i = 0; i <= nums.length - 1; i++) {
                Integer s = set.ceiling(nums[i]);

                if (s != null && s <= t + nums[i]) {
                    return true;
                }

                Integer g = set.floor(nums[i]);

                if (g != null && nums[i] <= t + g) {
                    return true;
                }

                set.add(nums[i]);

                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }

            return false;
        }
    }
}
