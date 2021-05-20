package amazon.arraysAndStrings;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/29/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2973/
 */
public class MostCommonWord {
  public static void main(String[] args) {
    String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned = new String[]{"hit"};

    System.out.println(mostCommonWord(paragraph, banned));
  }

  private static String mostCommonWord(String paragraph, String[] banned) {
    String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
    HashMap<String, Integer> wordsCountMap = new HashMap<>();
    HashSet<String> bannedSet = new HashSet<>();

    for (String bannedWord : banned) {
        bannedSet.add(bannedWord);
    }

    for (String word : words) {
      if (! bannedSet.contains(word)) {
        int count = wordsCountMap.getOrDefault(word, 0);
        wordsCountMap.put(word, ++count);
      }
    }

    Map.Entry<String, Integer> maxEntry = null;
    for (Map.Entry<String, Integer> entry : wordsCountMap.entrySet())
    {
      if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
      {
        maxEntry = entry;
      }
    }

    return maxEntry.getKey();
  }
}
