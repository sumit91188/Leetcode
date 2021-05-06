package explore.arrays101;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/6/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
 */
public class ReplaceElementsWithGreatestElementOnRightSide {
  public static void main(String[] args) {
    int[] nums = new int[] {17,18,5,4,6,1};

    Solution solution = new Solution();
    int[] result = solution.replaceElements(nums);

    for (int num : result) {
      System.out.print(num + " ");
    }
  }

  private static class Solution {

    public int[] replaceElements(int[] nums) {
      int maxElm = nums[nums.length - 1];
      nums[nums.length - 1] = -1;

      for (int i = nums.length - 2; i >= 0; i--) {
        int currentMax = maxElm;
        if (maxElm < nums[i]) {
          maxElm = nums[i];
        }

        nums[i] = currentMax;
      }
      return nums;
    }
  }
}
