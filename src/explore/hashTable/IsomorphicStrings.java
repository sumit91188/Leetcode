package explore.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sumit Deo
 * @Date 7/17/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1117/
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic(s, t));
    }

    private static class Solution {
        private String transformString(String s) {
            Map<Character, Integer> indexMapping = new HashMap<>();
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < s.length(); ++i) {
                char c1 = s.charAt(i);

                indexMapping.putIfAbsent(c1, i);

                builder.append(indexMapping.get(c1));
            }
            return builder.toString();
        }

        public boolean isIsomorphic(String s, String t) {
            return transformString(s).equals(transformString(t));
        }
    }
}
