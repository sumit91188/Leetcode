package explore.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sumit Deo
 * @Date 7/27/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1137/
 */
public class UniqueWordAbbreviation {
    public static void main(String[] args) {
        String[] dict = new String[]{"deer", "door", "cake", "card"};
        ValidWordAbbr wordAbbr = new ValidWordAbbr(dict);

        System.out.println(wordAbbr.isUnique("dear"));
        System.out.println(wordAbbr.isUnique("cart"));
        System.out.println(wordAbbr.isUnique("cane"));
        System.out.println(wordAbbr.isUnique("make"));
        System.out.println(wordAbbr.isUnique("cake"));
    }

    private static class ValidWordAbbr {

        HashMap<String, Set<String>> map;
        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();

            for (String str : dictionary) {
                String key = getAbbreviation(str);
                if (! map.containsKey(key)) {
                    map.put(key, new HashSet<>());
                }
                map.get(key).add(str);
            }
        }

        private String getAbbreviation(String str) {
            String key = str;
            if (str.length() > 2) {
                key = String.valueOf(str.charAt(0));
                key += str.length() - 2;
                key += String.valueOf(str.charAt(str.length() - 1));
            }
            return key;
        }

        public boolean isUnique(String word) {
            String key = getAbbreviation(word);
            if (map.containsKey(key)) {
                if (map.get(key).contains(word)) {
                    return map.get(key).size() == 1;
                }
                return false;
            }
            return true;
        }
    }
}
