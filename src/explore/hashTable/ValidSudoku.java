package explore.hashTable;

import java.util.HashSet;

/**
 * @author Sumit Deo
 * @Date 7/26/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1126/
 * 
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        
        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(board));
    }

    private static class Solution {
        public boolean isValidSudoku(char[][] board) {
            int N = board.length;

            HashSet<Character>[] rows = new HashSet[N];
            HashSet<Character>[] columns = new HashSet[N];
            HashSet<Character>[] boxes = new HashSet[N];

            for (int i = 0; i < N; i++) {
                rows[i] = new HashSet<>();
                columns[i] = new HashSet<>();
                boxes[i] = new HashSet<>();
            }

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    char val = board[row][col];

                    if (val == '.') {
                        continue;
                    }

                    if (rows[row].contains(val)) {
                        return false;
                    }
                    rows[row].add(val);

                    if (columns[col].contains(val)) {
                        return false;
                    }
                    columns[col].add(val);

                    int id = (row / 3) * 3 + (col / 3);

                    if (boxes[id].contains(val)) {
                        return false;
                    }
                    boxes[id].add(val);
                }
            }

            return true;
        }
    }
}
