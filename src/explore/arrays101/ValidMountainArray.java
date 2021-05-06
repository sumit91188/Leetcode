package explore.arrays101;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/6/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
 */
public class ValidMountainArray {
  public static void main(String[] args) {
    int[] nums = new int[] {0,3,2,1};

    Solution solution = new Solution();
    boolean flag = solution.validMountainArray(nums);

    System.out.println(flag);
  }

  private static class Solution {

    public boolean validMountainArray(int[] nums) {
      if (nums.length < 3) {
        return false;
      }

      /*boolean upHill = true;
      boolean downHill = false;
      boolean reachedPeak = false;
      for (int i = 1; i <= nums.length - 1; i++) {
        if (nums[i - 1] == nums[i]) {
          return false;
        }

        if (! reachedPeak && upHill && nums[i - 1] > nums[i]) {
          upHill = false;
          reachedPeak = true;
          continue;
        }

        if (reachedPeak && downHill && nums[i - 1] <= nums[i]) {
          return false;
        }
      }

      return reachedPeak && upHill == false && downHill == true;*/

      boolean reachedPeak = false;
      for (int i = 1; i <= nums.length - 2; i++) {

        if (nums[i - 1] == nums[i] || nums[i] == nums[i + 1]) {
          return false;
        }
        
        if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
          reachedPeak = true;
          continue;
        }

        if (! reachedPeak && nums[i - 1] > nums[i]) {
          return false;
        }

        if (reachedPeak && nums[i] < nums[i + 1]) {
          return false;
        }
      }

      return reachedPeak == true;
    }
  }
}
