package amazon.arraysAndStrings;

import java.util.HashMap;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/27/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/902/
 */
public class MinWindowSubstring {
  public static void main(String[] args) {
    String s1 = "ADOBECODEBANC";
    String t1 = "ABC";

    System.out.println(minWindow(s1, t1));

    String s2 = "a";
    String t2 = "a";

    System.out.println(minWindow(s2, t2));
  }

  private static String minWindow(String s, String t) {
    int left = 0;
    int right = 0;
    String smallestWindow = "";

    HashMap<Character, Integer> tMap = new HashMap<>();
    for (int i = 0; i <= t.length() - 1; i++) {
      int count = tMap.getOrDefault(t.charAt(i), 0);
      tMap.put(t.charAt(i), count++);
    }

    while (right <= s.length() - 1) {
      if (tMap.containsKey(s.charAt(right))) {
        smallestWindow = s.substring(left, right);
      }
    }
    return smallestWindow;
  }
}
