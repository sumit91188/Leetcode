package explore.arraysAndStrings;

/**
 * @author Sumit Deo
 * @Date 7/28/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = new int[] {1,7,3,6,5,6};
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(nums));
    }

    private static class Solution {
        public int pivotIndex(int[] nums) {
            int sum = 0;
            int leftSum = 0;

            for (int num : nums) {
                sum += num;
            }

            for (int i = 0; i < nums.length; i++) {
                if (leftSum == sum - leftSum - nums[i]) {
                    return i;
                }
                leftSum += nums[i];
            }

            return -1;
        }
    }
}
