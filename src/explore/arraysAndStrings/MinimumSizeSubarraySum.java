package explore.arraysAndStrings;

/**
 * @author Sumit Deo
 * @Date 8/1/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,2,4,3};
        int target = 7;

        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(nums, target));
    }

    private static class Solution {
        public int minSubArrayLen(int[] nums, int target) {
            int numOfSubArrayElems = 0;

            if (nums.length > 0 && target > 0) {
                numOfSubArrayElems = Integer.MAX_VALUE;
                for (int i = 0; i < nums.length; i++) {
                    int sum = 0;
                    int j = i;
                    while (sum < target & j < nums.length) {
                        sum += nums[j++];
                    }

                    if (sum >= target) {
                        numOfSubArrayElems = Math.min(numOfSubArrayElems, j - i);
                    }
                }
            }

            return numOfSubArrayElems == Integer.MAX_VALUE ? 0 : numOfSubArrayElems;
        }
    }
}
