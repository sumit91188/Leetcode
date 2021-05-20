package amazon.arraysAndStrings;

import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/29/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2972/
 */
public class ValidParentheses {
  public static void main(String[] args) {
    String str1 = "()";
    String str2 = "(){}[]";
    String str3 = "(]";
    String str4 = "([)]";
    String str5 = "{[]}";

    System.out.println(isValid(str1));
    System.out.println(isValid(str2));
    System.out.println(isValid(str3));
    System.out.println(isValid(str4));
    System.out.println(isValid(str5));
  }

  private static boolean isValid(String str) {
    Stack<Character> characterStack = new Stack<>();
    char[] chars = str.toCharArray();

    for (char ch : chars) {
        if (ch == '{') {
          characterStack.push('}');
        }
        else if (ch == '['){
          characterStack.push(']');
        }
        else if (ch == '(') {
          characterStack.push(')');
        }
        else {
          if (characterStack.empty() || ch != characterStack.pop()) {
            return false;
          }
        }
    }

    return characterStack.empty();
  }
}
