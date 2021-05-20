package amazon.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/27/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2970/
 */
public class Anagrams {
  public static void main(String[] args) {
    String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
    String[] strs2 = {""};
    String[] strs3 = {"a"};

    System.out.println(groupAnagrams(strs1));
    System.out.println(groupAnagrams(strs2));
    System.out.println(groupAnagrams(strs3));
  }

  private static List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> sortedMap = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = String.valueOf(chars);
      if (!sortedMap.containsKey(key)) {
        sortedMap.put(key, new ArrayList<>());
      }
      sortedMap.get(key).add(str);
    }
    return new ArrayList<>(sortedMap.values());
  }
}
