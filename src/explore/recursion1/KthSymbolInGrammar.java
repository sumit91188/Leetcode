package explore.recursion1;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.recursion1
 * @date 5/13/21
 * @comment: https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/
 */
public class KthSymbolInGrammar {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.kthGrammar(4, 5));
  }

  private static class Solution {

    public int kthGrammar(int n, int k) {
      if (n == 1 && k == 1) {
        return 0;
      }
      return 0;
    }
  }
}
