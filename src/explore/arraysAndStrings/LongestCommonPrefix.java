package explore.arraysAndStrings;

/**
 * @author Sumit Deo
 * @Date 8/1/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[] {"flower","flow","flight"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }

    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            String prefix = "";
            if (strs.length != 0) {
                prefix = strs[0];
                for (int i = 1; i < strs.length; i++) {
                    while (strs[i].indexOf(prefix) != 0) {
                        prefix = prefix.substring(0, prefix.length() - 1);
                        if (prefix.isEmpty()) {
                            return prefix;
                        }
                    }
                }
            }

            return prefix;
        }
    }
}
