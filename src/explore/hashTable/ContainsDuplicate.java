package explore.hashTable;

import java.util.HashSet;

/**
 * @author Sumit Deo
 * @Date 7/17/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1112/
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,2,3,5};

        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(nums));
    }

    private static class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();

            for (int num : nums) {
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
            }
            return false;
        }
    }
}
