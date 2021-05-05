package explore.arrays101;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/5/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
 */
public class NumbersWithEvenNumOfDigits {
  public static void main(String[] args) {
    int[] nums = new int[] {12,345,2,6,7896};

    Solution solution = new Solution();
    int numbersWithEvenNumOfDigits = solution.findNumbers(nums);
    System.out.println(numbersWithEvenNumOfDigits);
  }

  private static class Solution {

    public int findNumbers(int[] nums) {
      int count = 0;

      for (int num : nums) {
        int numOfDigit = 1;
        while (num / 10 != 0) {
          numOfDigit++;
          num = num / 10;
        }

        if (numOfDigit % 2 == 0) {
          count++;
        }
      }
      return count;
    }
  }
}
