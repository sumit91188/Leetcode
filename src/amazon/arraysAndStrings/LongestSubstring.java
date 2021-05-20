package amazon.arraysAndStrings;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/20/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2961/
 */
public class LongestSubstring {
  public static void main(String[] args) {

    String testString1 = "abcabcbb";
    String testString2 = "bbbb";
    String testString3 = "pwwkew";
    String testString4 = " ";

    System.out.println(lengthOfLongestSubstring(testString1));
    System.out.println(lengthOfLongestSubstring(testString2));
    System.out.println(lengthOfLongestSubstring(testString3));
    System.out.println(lengthOfLongestSubstring(testString4));
  }

  private static int lengthOfLongestSubstring(String s) {
    int maxCount = 0;
    int count = 0;
    String currentStr = "";

    char[] inputChars = s.toCharArray();

    for (char inputChar: inputChars) {
      if (currentStr.indexOf(inputChar) != -1) {
        if (maxCount < count) {
          maxCount = count;
        }
        currentStr = currentStr.substring(currentStr.indexOf(inputChar) + 1);
        currentStr += inputChar;
        count = currentStr.length();
      }
      else {
        count++;
        currentStr += inputChar;
      }
    }

    if (maxCount < count) {
      maxCount = count;
    }
    return maxCount;
  }
}
