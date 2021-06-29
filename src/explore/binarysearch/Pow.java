package explore.binarysearch;

/**
 * @author Sumit Deo
 * @Date 6/28/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/powx-n/
 */
public class Pow {
    public static void main(String[] args) {
        double x = 2.000;
        int n = 10;

        Solution solution = new Solution();
        System.out.println(solution.myPow(x, n));
    }

    private static class Solution {
        public double myPow(double x, int n) {
            long N = n;

            if (N < 0) {
                x = 1 / x;
                N = - N;
            }

            double ans = 1;
            double current_product = x;

            for (long i = N; i > 0; i /= 2) {
                if (i % 2 == 1) {
                    ans = ans * current_product;
                }

                current_product = current_product * current_product;
            }
            return ans;
        }
    }
}
