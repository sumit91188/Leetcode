package explore.arraysAndStrings;

/**
 * @author Sumit Deo
 * @Date 7/28/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] nums = new int[]{9,9,9};

        Solution solution = new Solution();
        int[] sumDigits = solution.plusOne(nums);

        for (int num : sumDigits) {
            System.out.print(num + " ");
        }
    }

    private static class Solution {
        public int[] plusOne(int[] nums) {
            int n = nums.length;

            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] == 9) {
                    nums[i] = 0;
                }
                else {
                    nums[i]++;
                    return nums;
                }
            }

            nums = new int[n + 1];
            nums[0] = 1;
            return nums;
        }
    }
}
