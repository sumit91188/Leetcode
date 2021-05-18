package explore.binarysearch;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.binarysearch
 * @date 5/17/21
 * @comment: https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *
 *
 * Constraints:
 *
 * 0 <= x <= 231 - 1
 */
public class Sqrt {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.mySqrt(4));
    System.out.println(solution.mySqrt(8));
    System.out.println(solution.mySqrt(2147395599));
  }

  private static class Solution {

    public int mySqrt(int num) {

      if (num < 2) {
        return num;
      }

      long left = 2;
      long right = num / 2;

      while (left <= right) {
        long mid = left + (right - left) / 2;
        long sqr = mid * mid;
        if (num > sqr) {
          left = mid + 1;
        }
        else if (num < sqr) {
          right = mid - 1;
        }
        else {
          return (int) mid;
        }
      }

      return (int) right;
    }
  }
}
