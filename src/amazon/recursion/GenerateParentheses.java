package amazon.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sumit Deo
 * @Date 5/23/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2772/
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> results = solution.generateParenthesis(3);

        for (String result : results) {
            System.out.print(result + " ");
        }
    }

    private static class Solution {


        public List<String> generateParenthesis(int n) {
            List<String> results = new ArrayList<>();
            backTrack(results, new StringBuilder(), 0, 0, n);
            return results;
        }

        private void backTrack(List<String> results, StringBuilder currentStr, int opened, int closed, int max) {
            if (currentStr.length() == max * 2) {
                results.add(currentStr.toString());
                return;
            }

            if (opened < max) {
                currentStr.append('(');
                backTrack(results, currentStr, opened + 1, closed, max);
                currentStr.deleteCharAt(currentStr.length() - 1);
            }

            if (closed < opened) {
                currentStr.append(')');
                backTrack(results, currentStr, opened, closed + 1, max);
                currentStr.deleteCharAt(currentStr.length() - 1);
            }
        }
    }
}
