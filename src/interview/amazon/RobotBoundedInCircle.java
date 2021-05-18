package interview.amazon;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package interview.amazon
 * @date 5/15/21
 * @comment: https://leetcode.com/problems/robot-bounded-in-circle/solution/
 */
public class RobotBoundedInCircle {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isRobotBounded("GGLLGG"));
  }

  private static class Solution {

    public boolean isRobotBounded(String instructions) {
      int idx = 0;
      //north = 0, east = 1; south = 2; west = 3;
      int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      int x = 0;
      int y = 0;

      for (char ch : instructions.toCharArray()) {
        if (ch == 'L') {
          idx = (idx + 3) % 4;
        }
        else if (ch == 'R') {
          idx = (idx + 1) % 4;
        }
        else {
          x += directions[idx][0];
          y += directions[idx][1];
        }
      }

      return (x == 0 && y == 0) || idx != 0;
    }
  }
}
