package interview.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package interview.amazon
 * @date 5/15/21
 * @comment: You have a map that marks the location of a treasure island. Some of the map area has
 * jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers
 * trying to find the treasure. So you must figure out a shortest route to the treasure island.
 * <p>
 * Assume the map area is a two dimensional grid, represented by a matrix of characters. You must
 * start from the top-left corner of the map and can move one block up, down, left or right at a
 * time. The treasure island is marked as X in a block of the matrix. X will not be at the top-left
 * corner. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous
 * blocks. You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is
 * always safe. Output the minimum number of steps to get to the treasure.
 * <p>
 * Example:
 * <p>
 * Input: [['O', 'O', 'O', 'O'], ['D', 'O', 'D', 'O'], ['O', 'O', 'O', 'O'], ['X', 'D', 'D', 'O']]
 * <p>
 * Output: 5 Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route
 * takes 5 steps. Solution Java BFS: https://leetcode.com/playground/uQoVfEmr Time complexity: O(r *
 * c). Space complexity: O(r * c).
 */
public class TreasureIsland {

  public static void main(String[] args) {
    char[][] grid = new char[][]{{'O', 'O', 'O', 'O'}, {'D', 'O', 'D', 'O'}, {'O', 'O', 'O', 'O'},
        {'X', 'D', 'D', 'O'}};

    Solution solution = new Solution();
    System.out.println(solution.minSteps(grid));
  }

  private static class Solution {

    public int minSteps(char[][] grid) {
      if (grid == null || grid.length == 0 || grid[0].length == 0) {
        return -1;
      }

      int steps = 0;
      Queue<Coordinate> queue = new LinkedList<>();
      queue.add(new Coordinate(0, 0));
      int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
      boolean[][] visited = new boolean[grid.length][grid[0].length];
      visited[0][0] = true;

      while (!queue.isEmpty()) {
        int size = queue.size();

        for (int i = 0; i <= size - 1; i++) {
          Coordinate coordinate = queue.poll();
          int x = coordinate.x;
          int y = coordinate.y;

          if (grid[x][y] == 'X') {
            return steps;
          }

          for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length
                && grid[newX][newY] != 'D' && !visited[newX][newY]) {
                queue.add(new Coordinate(newX, newY));
                visited[newX][newY] = true;
            }
          }
          steps++;
        }
      }

      return -1;
    }

    class Coordinate {

      int x;
      int y;

      Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
      }
    }
  }
}
