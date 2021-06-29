package explore.binarysearch;

/**
 * @author Sumit Deo
 * @Date 6/28/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/137/conclusion/978/
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        int num = 808201;
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(num));
    }

    private static class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }

            long left = 2;
            long right = num / 2;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                long guessedSquare = mid * mid;

                if (guessedSquare > num) {
                    right = mid - 1;
                }
                else if (guessedSquare < num) {
                    left = mid + 1;
                }
                else {
                    return true;
                }
            }
            return false;
        }
    }
}
