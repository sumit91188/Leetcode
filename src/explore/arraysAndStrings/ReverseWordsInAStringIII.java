package explore.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sumit Deo
 * @Date 8/1/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1165/
 */
public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(s));
    }

    private static class Solution {
        public String reverseWords(String s) {
            String[] words = s.trim().split("\\s+");

            for (int i = 0; i < words.length; i++) {
                char[] chars = words[i].toCharArray();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < chars.length; j++) {
                    sb.insert(0, chars[j]);
                }
                words[i] = sb.toString();
            }

            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                sb.append(word);
                sb.append(" ");
            }

            return sb.toString().trim();
        }
    }
}
