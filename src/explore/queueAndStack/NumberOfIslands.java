package explore.queueAndStack;

/**
 * @author Sumit Deo
 * @Date 8/7/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));
    }

    private static class Solution {
        char[][] grid;
        int rows, columns;

        public int numIslands(char[][] grid) {
            int numOfIslands = 0;
            this.grid = grid;

            if (grid != null) {
                rows = grid.length;

                if (rows > 0) {
                    columns = grid[0].length;
                    for (int r = 0; r < rows; r++) {
                        for (int c = 0; c < columns; c++) {
                            if (grid[r][c] == '1') {
                                numOfIslands++;
                                dfs(r, c);
                            }
                        }
                    }
                }
            }

            return numOfIslands;
        }

        private void dfs(int r, int c) {
            if (r < 0 || c < 0 || r >= rows || c >= columns || grid[r][c] == '0') {
                return;
            }

            grid[r][c] = '0';

            dfs(r - 1, c);
            dfs(r + 1, c);
            dfs(r, c - 1);
            dfs(r, c + 1);
        }
    }
}
