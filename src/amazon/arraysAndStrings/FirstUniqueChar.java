package amazon.arraysAndStrings;

import java.util.HashMap;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/29/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/480/
 */
public class FirstUniqueChar {
  public static void main(String[] args) {
    String str1 = "leetcode";
    String str2 = "loveleetcode";
    String str3 = "aabb";

    System.out.println(firstUniqueChar(str1));
    System.out.println(firstUniqueChar(str2));
    System.out.println(firstUniqueChar(str3));
  }

  private static int firstUniqueChar(String str) {

    for (int i = 0; i <= str.length() - 1; i++) {
        char ch = str.charAt(i);
        if (i == 0) {
          if (str.substring(i + 1).indexOf(ch) == -1) {
            return i;
          }
        }
        else if (i == str.length() - 1) {
          if (str.substring(0, i).indexOf(ch) == -1) {
            return i;
          }
        }
        else {
          if ((str.substring(0, i) + str.substring(i + 1)).indexOf(ch) == -1) {
            return i;
          }
        }
    }

    return -1;
  }
}
