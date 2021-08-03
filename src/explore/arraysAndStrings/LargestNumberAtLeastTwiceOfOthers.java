package explore.arraysAndStrings;

/**
 * @author Sumit Deo
 * @Date 7/28/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        int[] nums = new int[]{3,6,1,0, 5};
        Solution solution = new Solution();
        System.out.println(solution.dominantIndex(nums));
    }

    private static class Solution {
        public int dominantIndex(int[] nums) {
            int maxIndex = -1;
            int maxNum = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > maxNum) {
                    maxIndex = i;
                    maxNum = nums[i];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (i == maxIndex) {
                    continue;
                }

                if (maxNum < 2 * nums[i]) {
                    return -1;
                }
            }

            return maxIndex;
        }
    }
}
