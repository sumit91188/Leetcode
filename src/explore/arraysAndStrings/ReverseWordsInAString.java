package explore.arraysAndStrings;

import java.util.Arrays;

/**
 * @author Sumit Deo
 * @Date 8/1/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1164/
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "Alice does not even like bob   ";

        Solution solution = new Solution();
        System.out.println(solution.reverseWords(s));
    }

    private static class Solution {
        public String reverseWords(String s) {
            String[] words = s.trim().split("\\s+");
            int left = 0;
            int right = words.length - 1;

            while (left < right) {
                String temp = words[right];
                words[right] = words[left];
                words[left] = temp;
                left++;
                right--;
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
