package explore.arrays101;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/5/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
 */
public class MaxConsecutiveOnes {
  public static void main(String[] args) {
    int[] nums = new int[] {1,1,0,1,1,1};

    Solution solution = new Solution();
    int maxConsecutiveOnes = solution.findMaxConsecutiveOnes(nums);
    System.out.println(maxConsecutiveOnes);
  }

  private static class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
      int maxCount = 0;
      int count = 0;

      for (int num : nums) {
        if (num == 1) {
          count++;
        }
        else {
          count = 0;
        }
        maxCount = Math.max(maxCount, count);
      }

      return maxCount;
    }
  }
}
