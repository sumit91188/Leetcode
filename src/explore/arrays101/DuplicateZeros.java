package explore.arrays101;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/5/21
 * @comment:
 *     https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
 */
public class DuplicateZeros {
  public static void main(String[] args) {
    int[] nums = new int[] {1,0,2,3,0,4,5,0};

    Solution solution = new Solution();
    solution.duplicateZeros(nums);

    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  private static class Solution {

    public void duplicateZeros(int[] nums) {
      int countZeros = 0;
      for (int num : nums) {
        if (num == 0) {
          countZeros++;
        }
      }

      int[] copiedNums = new int[nums.length + countZeros];

      int j = 0;
      for (int i = 0; i <= nums.length - 1; i++) {
        copiedNums[j++] = nums[i];
        if (nums[i] == 0) {
          copiedNums[j++] = 0;
        }
      }

      for (int i = 0; i <= nums.length - 1; i++) {
        nums[i] = copiedNums[i];
      }
    }
  }
}
