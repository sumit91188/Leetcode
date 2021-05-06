package explore.arrays101;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/6/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/
 */
public class RemoveDuplicatesFromSortedArray {
  public static void main(String[] args) {
    int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};

    Solution solution = new Solution();
    int len = solution.removeDuplicates(nums);

    System.out.println(len);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  private static class Solution {

    public int removeDuplicates(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }

      int j = 1;
      int prevElm = nums[0];
      for (int i = 1; i <= nums.length - 1; i++) {
        if (nums[i] != prevElm) {
          nums[j++] = nums[i];
        }
        prevElm = nums[i];
      }

      return j;
    }
  }
}
