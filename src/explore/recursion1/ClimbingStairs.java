package explore.recursion1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.recursion1
 * @date 5/13/21
 * @comment: https://leetcode.com/problems/climbing-stairs/solution/
 */
public class ClimbingStairs {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.climbStairs(2));
  }

  private static class Solution {

    public int climbStairs(int n) {
      int[] cache = new int[n + 1];
      return climbStairs(n,0, cache);
    }

    private int climbStairs(int n, int i, int[] cache) {

      if (i > n) {
        return 0;
      }
      if (n == i) {
        return 1;
      }

      if (cache[i] != 0) {
        return cache[i];
      }

      cache[i] = (climbStairs(n, i + 1, cache) + climbStairs(n, i + 2, cache));
      return cache[i];
    }
  }
}
