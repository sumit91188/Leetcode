package amazon.arraysAndStrings;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/26/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2968/
 */
public class StrStr {
  public static void main(String[] args) {
    String haystack1 = "hello";
    String needle1 = "ll";

    System.out.println(strStr(haystack1, needle1));

    String haystack2 = "aaaaa";
    String needle2 = "bba";

    System.out.println(strStr(haystack2, needle2));

    String haystack3 = "a";
    String needle3 = "a";

    System.out.println(strStr(haystack3, needle3));
  }

  private static int strStr(String haystack, String needle) {

    if (needle.length() == 0) {
      return 0;
    }

    char[] haystackChars = haystack.toCharArray();
    char[] needlesChars = needle.toCharArray();

    for (int i = 0; i <= haystackChars.length - needlesChars.length; i++) {
      int j = 0;
      while (j <= needlesChars.length - 1) {
        if (haystackChars[i + j] != needlesChars[j]) {
          break;
        }
        j++;
        if (j == needlesChars.length) {
          return i;
        }
      }
    }

    return -1;
  }
}
