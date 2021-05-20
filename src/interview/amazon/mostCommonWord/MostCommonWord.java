package interview.amazon.mostCommonWord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium
 * @date 10/4/20
 * @comment: Given a paragraph and a list of banned words, return the most frequent word that is not
 *     in the list of banned words.
 *     Input: paragraph = "Bob hit a ball, the hit BALL flew far after
 *     it was hit."
 *     banned = ["hit"]
 *     Output: "ball"
 *     Explanation: "hit" occurs 3 times, but it is a
 *     banned word. "ball" occurs twice (and no other word does), so it is the most frequent
 *     non-banned word in the paragraph. Note that words in the paragraph are not case sensitive,
 *     that punctuation is ignored (even if adjacent to words, such as "ball,"), and that "hit"
 *     isn't the answer even though it occurs more because it is banned.
 */
public class MostCommonWord {
  public static void main(String[] args) {
    String paragraph = "Bob hit a flew ball, flew the hit BALL flew far after FLEW ball ball it was hit.";
    String[] bannedWords = {"hit"};
    Object[] result = getMostCommonWord(paragraph, bannedWords);
    for (Object str : result) {
      System.out.print(str + " ");
    }
  }

  private static Object[] getMostCommonWord(String paragraph, String[] bannedWords) {
    String[] words = paragraph.toLowerCase().split("[^a-zA-Z]+");
    Arrays.sort(words);
    HashMap<String, Integer> wordCount = new HashMap<>();
    Set<String> ban = new HashSet<String>();
    for (int i=0; i<bannedWords.length; i++)
      ban.add(bannedWords[i]);

    for (int i = 0; i < words.length; i++) {
      if (! ban.contains(words[i])) {
        if (! wordCount.containsKey(words[i])) {
          wordCount.put(words[i], 1);
        }
        else {
          wordCount.put(words[i], wordCount.get(words[i]) + 1);
        }
      }
    }

    HashSet<String> results = new HashSet<>();
    int maxCount = 0;

    for (String word : wordCount.keySet()) {
      if (wordCount.get(word) == maxCount) {
        results.add(word);
      }
      else if (wordCount.get(word) > maxCount){
        results.clear();
        results.add(word);
        maxCount = wordCount.get(word);
      }
    }

    return results.toArray();
  }
}
