package explore.arrays101;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/5/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/
 */
public class SquaresOfASortedArray {
  public static void main(String[] args) {
    int[] nums = new int[] {-4,-1,0,3,10};

    Solution solution = new Solution();
    int[] squares = solution.sortedSquares(nums);

    for (int square : squares) {
      System.out.print(square + " ");
    }
  }

  private static class Solution {

    public int[] sortedSquares(int[] nums) {
      int numOfElms = nums.length;
      int[] squares = new int[numOfElms];
      int leftIndex = 0;
      int rightIndex = numOfElms - 1;

      for (int i = numOfElms - 1; i >= 0; i--) {
        if (Math.abs(nums[leftIndex]) > Math.abs(nums[rightIndex])) {
          squares[i] = (int) Math.pow(nums[leftIndex], 2);
          leftIndex++;
        }
        else {
          squares[i] = (int) Math.pow(nums[rightIndex], 2);
          rightIndex--;
        }
      }
      return squares;
    }
  }
}
