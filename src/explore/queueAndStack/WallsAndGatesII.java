package explore.queueAndStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sumit Deo
 * @Date 8/7/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/walls-and-gates/
 */
public class WallsAndGatesII {
    public static void main(String[] args) {
        int[][] rooms = new int[][]{{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};

        Solution solution = new Solution();
        solution.wallsAndGates(rooms);

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + "\t\t\t\t\t\t");
            }
            System.out.println();
        }
    }

    private static class Solution {
        int EMPTY = Integer.MAX_VALUE;
        int GATE = 0;

        int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public void wallsAndGates(int[][] rooms) {
            if (rooms.length == 0) {
                return;
            }

            int rows = rooms.length;
            int columns = rooms[0].length;

            Queue<int[]> queue = new LinkedList<>();

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    if (rooms[row][column] == GATE) {
                        queue.add(new int[]{row, column});
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int row = point[0];
                int column = point[1];

                for (int[] direction : DIRECTIONS) {
                    int r = row + direction[0];
                    int c = column + direction[1];

                    if (r < 0 || c < 0 || r >= rows || c >= columns || rooms[r][c] != EMPTY) {
                        continue;
                    }

                    rooms[r][c] = rooms[row][column] + 1;
                    queue.add(new int[]{r, c});
                }
            }
        }
    }
}
