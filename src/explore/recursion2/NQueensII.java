package explore.recursion2;

import java.util.HashSet;

/**
 * @author Sumit Deo
 * @Date 5/21/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/n-queens-ii/solution/
 */
public class NQueensII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(8));
    }

    private static class Solution {
        int size;
        
        public int totalNQueens(int n) {
            size = n;
            return backtrack(0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        }

        private int backtrack(int row, HashSet<Integer> diag, HashSet<Integer> antiDiag, HashSet<Integer> cols) {

            if (row == size) {
                return 1;
            }

            int solutions = 0;

            for (int col = 0; col <= size - 1; col++) {
                int currentDiag = row - col;
                int currentAntiDiag = row + col;

                if (cols.contains(col) || diag.contains(currentDiag) || antiDiag.contains(currentAntiDiag)) {
                    continue;
                }

                cols.add(col);
                diag.add(currentDiag);
                antiDiag.add(currentAntiDiag);

                solutions += backtrack(row + 1, diag, antiDiag, cols);

                cols.remove(col);
                diag.remove(currentDiag);
                antiDiag.remove(currentAntiDiag);
            }

            return solutions;
        }
    }
}
