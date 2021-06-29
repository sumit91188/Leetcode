package explore.binarysearch;

/**
 * @author Sumit Deo
 * @Date 6/28/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/
 */
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = new char[] {'c', 'f', 'j'};
        Solution solution = new Solution();
        System.out.println(solution.nextGreatestLetter(letters, 'j'));
    }

    private static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0;
            int right = letters.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (letters[mid] <= target) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }

            return letters[left % letters.length];
        }
    }
}
