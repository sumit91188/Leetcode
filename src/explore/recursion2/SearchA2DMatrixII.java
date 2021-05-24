package explore.recursion2;

/**
 * @author Sumit Deo
 * @Date 5/20/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/
 */
public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 20;

        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, target));
    }

    private static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length - 1;
            int col = 0;

            while (row >= 0 && col <= matrix[0].length - 1) {
                if (matrix[row][col] > target) {
                    row--;
                }
                else if (matrix[row][col] < target) {
                    col++;
                }
                else {
                    return true;
                }
            }
            return false;
        }
    }
}
