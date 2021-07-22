package explore.hashTable;

import java.util.HashSet;

/**
 * @author Sumit Deo
 * @Date 7/17/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1176/
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,2,3,4};

        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums));
    }

    private static class Solution {
        public int singleNumber(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            int setSum = 0;
            int numSum = 0;

            for (int num : nums) {
                if (!set.contains(num)) {
                    set.add(num);
                    setSum += num;
                }

                numSum += num;
            }

            return 2 * setSum - numSum;
        }
    }
}
