package explore.arrays101;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/6/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
 */
public class SortArrayByParity {
  public static void main(String[] args) {
    int[] nums = new int[] {1,3,8,5,9,7,4};

    Solution solution = new Solution();
    solution.sortArrayByParity(nums);

    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  private static class Solution {

    public void sortArrayByParity(int[] nums) {
      int i = 0;
      int j = nums.length - 1;

      while (i < j) {
        if (nums[i] % 2 > nums[j] % 2) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }

        if (nums[i] % 2 == 0) i++;
        if (nums[j] % 2 == 1) j--;
      }
    }
  }
}
