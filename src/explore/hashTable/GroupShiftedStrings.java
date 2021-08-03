package explore.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sumit Deo
 * @Date 7/26/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1125/
 */
public class GroupShiftedStrings {
    public static void main(String[] args) {
        String[] strs = new String[] {"abc","bcd","acef","xyz","az","ba","a","z"};
        Solution solution = new Solution();
        List<List<String>> groups = solution.groupStrings(strs);

        for (List<String> groupStrs : groups) {
            for (String str : groupStrs) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    private static class Solution {
        public List<List<String>> groupStrings(String[] strs) {

            if (strs.length == 0) {
                return new ArrayList<>();
            }

            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] chars = str.toCharArray();

                if (chars.length > 0) {
                    int diff = chars[0] - 'a';
                    for (int i = 0; i < chars.length; i++) {
                        if (chars[i] - diff < 'a') {
                            chars[i] = (char) (chars[i] - diff + 26);
                        }
                        else {
                            chars[i] = (char) (chars[i] - diff);
                        }
                    }
                }

                String ns = new String(chars);
                if (! map.containsKey(ns)) {
                    map.put(ns, new ArrayList<>());
                }

                map.get(ns).add(str);
            }

            return new ArrayList(map.values());
        }
    }
}
