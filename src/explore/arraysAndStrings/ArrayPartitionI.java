package explore.arraysAndStrings;

import java.util.Arrays;

/**
 * @author Sumit Deo
 * @Date 8/1/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1154/
 */
public class ArrayPartitionI {
    public static void main(String[] args) {
        int[] nums = new int[] {6,2,6,5,1,2};
        Solution solution = new Solution();
        System.out.println(solution.arrayPairSum(nums));
    }

    private static class Solution {
        public int arrayPairSum(int[] nums) {
            int maximizedMin = 0;

            if (nums.length != 0) {
                Arrays.sort(nums);
                for (int i = 0; i < nums.length; i = i + 2) {
                    maximizedMin += Math.min(nums[i], nums[i + 1]);
                }
            }

            return maximizedMin;
        }
    }
}
