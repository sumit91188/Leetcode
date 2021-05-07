package explore.arrays101;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/6/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/
 */
public class MoveZeros {
  public static void main(String[] args) {
    int[] nums = new int[] {0,0,1,3,8,0,5,9,7,0};

    Solution solution = new Solution();
    solution.moveZeroes(nums);

    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  private static class Solution {

    public void moveZeroes(int[] nums) {
      int lastZeroFoundAt = 0;
      for (int i = 0; i <= nums.length - 1; i++) {
        if (nums[i] != 0) {
          nums[lastZeroFoundAt++] = nums[i];
        }
      }

      for (int i = lastZeroFoundAt; i <= nums.length - 1; i++) {
        nums[i] = 0;
      }
    }
  }
}
