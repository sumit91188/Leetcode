package amazon.recursion;

/**
 * @author Sumit Deo
 * @Date 5/24/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/interview/card/amazon/84/recursion/2989/
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }

    private static class Solution {
        private char[][] board;
        private int rows;
        private int cols;

        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.rows = board.length;
            this.cols = board[0].length;

            for (int row = 0; row <= rows - 1; row++) {
                for (int col = 0; col <= cols - 1; col++) {
                    if (backtrack(row, col, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(int row, int col, String word, int index) {
            if (index >= word.length()) {
                return true;
            }

            if (row < 0 || row == rows || col < 0 || col == cols || board[row][col] != word.charAt(index)) {
                return false;
            }

            boolean ret = false;

            board[row][col] = '#';

            int[] rowOffsets = {0, 1, 0, -1};
            int[] colOffsets = {1, 0, -1, 0};

            for (int d = 0; d < 4; d++) {
                ret = backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
                if (ret) {
                    break;
                }
            }

            board[row][col] = word.charAt(index);
            return ret;
        }
    }
}
