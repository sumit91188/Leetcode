package explore.queueAndStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sumit Deo
 * @Date 8/7/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/walls-and-gates/
 */
public class WallsAndGates {
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
        int WALL = -1;

        int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] rooms;
        int rows;
        int columns;

        public void wallsAndGates(int[][] rooms) {
            if (rooms.length == 0) {
                return;
            }

            this.rooms = rooms;
            this.rows = rooms.length;
            this.columns = rooms[0].length;

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    if (rooms[row][column] == EMPTY) {
                        rooms[row][column] = distanceToNearestGate(row, column);
                    }
                }
            }
        }

        private int distanceToNearestGate(int row, int column) {
            int[][] distance = new int[rows][columns];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{row, column});

            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int r = point[0];
                int c = point[1];

                for (int[] direction : DIRECTIONS) {
                    int r1 = r + direction[0];
                    int c1 = c + direction[1];

                    if (r1 < 0 || c1 < 0 || r1 >= rows || c1 >= columns || rooms[r1][c1] == WALL || distance[r1][c1] != 0) {
                        continue;
                    }

                    distance[r1][c1] = distance[r][c] + 1;

                    if (rooms[r1][c1] == GATE) {
                        return distance[r1][c1];
                    }

                    queue.add(new int[] {r1, c1});
                }
            }

            return EMPTY;
        }
    }
}
