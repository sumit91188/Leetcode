package explore.recursion1;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.recursion1
 * @date 5/12/21
 * @comment: https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/
 */
public class Pow {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.myPow(2, -4));
  }

  private static class Solution {

    public double myPow(double x, int n) {
      double result = myPow1(x, Math.abs(n));
      return n < 0 ? (1 / result) : result;
    }

    private double myPow1(double x, int n) {
      if (n == 0) {
        return 1;
      }

      double result = myPow1(x, n/2);

      if (n % 2 == 0) {
        return result * result;
      }
      else {
        return x * result * result;
      }
    }
  }
}
