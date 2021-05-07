package explore.arrays101;

import java.util.Arrays;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/7/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3228/
 */
public class HeightChecker {
  public static void main(String[] args) {
    int[] nums = new int[] {1,1,4,2,1,3};

    Solution solution = new Solution();
    int indicesDoNotMatch = solution.heightChecker(nums);

    System.out.println(indicesDoNotMatch);
  }

  private static class Solution {

    public int heightChecker(int[] nums) {
      int[] orderedNums = Arrays.copyOf(nums, nums.length);
      Arrays.sort(orderedNums);
      int indicesDoNotMatch = 0;
      for (int i = 0; i <= nums.length - 1; i++) {
        if (nums[i] != orderedNums[i]) {
          indicesDoNotMatch++;
        }
      }
      return indicesDoNotMatch;
    }
  }
}
