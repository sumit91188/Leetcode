package explore.queueAndStack;

/**
 * @author Sumit Deo
 * @Date 8/8/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/perfect-squares/
 * n=(4)pow(k) * (8m+7)
 */
public class PerfectSquares {
    public static void main(String[] args) {
        int n = 1;

        Solution solution = new Solution();
        System.out.println(solution.numSquares(n));
    }

    private static class Solution {
        public int numSquares(int n) {
            while (n % 4 == 0) {
                n /= 4;
            }

            if (n % 8 == 7) {
                return 4;
            }

            if (isPerfectSquare(n)) {
                return 1;
            }

            for (int i = 1; i * i < n; i++) {
                if (isPerfectSquare(n - i * i)) {
                    return 2;
                }
            }

            return 3;
        }

        private boolean isPerfectSquare(int n) {
            int sqrt = (int) Math.sqrt(n);
            return sqrt * sqrt == n;
        }
    }
}
