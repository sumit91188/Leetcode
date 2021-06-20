package explore.recursion1;

import java.util.HashMap;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.recursion1
 * @date 5/12/21
 * @comment: https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1661/
 */
public class FibonacciNumber {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.fib(20));
  }

  private static class Solution {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int fib(int num) {
      if (hashMap.containsKey(num)) {
        return hashMap.get(num);
      }

      int result;
      if (num < 2) {
        result = num;
      }
      else {
        result = fib(num - 1) + fib(num - 2);
      }

      hashMap.put(num, result);
      return result;
    }
  }
}
