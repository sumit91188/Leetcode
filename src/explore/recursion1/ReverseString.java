package explore.recursion1;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.recursion1
 * @date 5/12/21
 * @comment: https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/
 */
public class ReverseString {

  public static void main(String[] args) {
    char[] chars = new char[]{'h','e','l','l','o'};
    Solution solution = new Solution();
    solution.reverseString(chars);

    for (char ch: chars) {
      System.out.print(ch + " ");
    }
  }

  private static class Solution {

    public void reverseString(char[] chars) {

      helper(chars, 0, chars.length - 1);
    }

    private void helper(char[] chars, int leftIndex, int rightIndex) {
      if (leftIndex >= rightIndex) {
        return;
      }
      char tempCh = chars[leftIndex];
      chars[leftIndex] = chars[rightIndex];
      chars[rightIndex] = tempCh;
      helper(chars, ++leftIndex, --rightIndex);
    }
  }
}
