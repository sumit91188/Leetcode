package explore.hashTable;

import java.util.*;

/**
 * @author Sumit Deo
 * @Date 7/25/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};

        Solution solution = new Solution();
        List<List<String>> anagrams = solution.groupAnagrams(strs);

        for (List<String> anagram : anagrams) {
            for (String str : anagram) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            /*if (strs.length == 0) return new ArrayList();
            Map<String, List> ans = new HashMap<>();
            for (String s : strs) {
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                String key = String.valueOf(ca);
                if (!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());*/

            if (strs.length == 0) {
                return new ArrayList<>();
            }

            Map<String, List> map = new HashMap<>();
            int[] count = new int[26];
            for (String str : strs) {
                Arrays.fill(count, 0);

                for (char ch : str.toCharArray()) {
                    count[ch - 'a']++;
                }

                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < 26; i++) {
                    sb.append("#");
                    sb.append(count[i]);
                }

                String key = sb.toString();

                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList());
                }
                map.get(key).add(str);
            }

            return new ArrayList(map.values());
        }
    }
}
