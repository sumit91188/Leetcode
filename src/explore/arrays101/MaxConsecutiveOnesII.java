package explore.arrays101;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/7/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3230/
 */
public class MaxConsecutiveOnesII {
  public static void main(String[] args) {
    int[] nums = new int[] {1, 0, 1, 1, 0, 1};

    Solution solution = new Solution();
    int maxConsecutiveOnes = solution.findMaxConsecutiveOnes(nums);

    System.out.println(maxConsecutiveOnes);
  }

  private static class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
      int maxConsecutiveOnes = 0;
      int consecutiveOnes;
      for (int i = 0; i <= nums.length - 1; i++) {
        int j = i;
        boolean hasZero = false;
        consecutiveOnes = 0;
        while (j <= nums.length - 1) {
          if (!hasZero && nums[j] == 0) {
            hasZero = true;
          } else if (nums[j] == 0) {
            break;
          }
          j++;
          consecutiveOnes++;
        }
        if (consecutiveOnes > maxConsecutiveOnes) {
          maxConsecutiveOnes = consecutiveOnes;
        }
      }

      return maxConsecutiveOnes;
    }
  }
}
