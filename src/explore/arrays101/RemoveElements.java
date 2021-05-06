package explore.arrays101;

import java.util.Arrays;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/5/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
 */
public class RemoveElements {
  public static void main(String[] args) {
    int[] nums = new int[] {0,1,2,2,3,0,4,2};

    Solution solution = new Solution();
    int len = solution.removeElement(nums, 2);

    System.out.println(len);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  private static class Solution {

    public int removeElement(int[] nums, int val) {
      int j = 0;
      for (int i = 0; i <= nums.length - 1; i++) {
        if (nums[i] != val) {
          nums[j] = nums[i];
          j++;
        }
      }

      return j;
    }
  }
}
