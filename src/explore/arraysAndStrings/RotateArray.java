package explore.arraysAndStrings;

import java.util.Arrays;

/**
 * @author Sumit Deo
 * @Date 8/1/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3;

        Solution solution = new Solution();
        solution.rotate(nums, k);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static class Solution {
        public void rotate(int[] nums, int k) {
            int[] copiedNums = Arrays.copyOf(nums, nums.length);
            k %= nums.length;

            for (int i = 0;  i < nums.length; i++) {
                nums[(i + k) % nums.length] = copiedNums[i];
            }
        }
    }
}
