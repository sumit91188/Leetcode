package explore.recursion1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.recursion1
 * @date 5/12/21
 * @comment: https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/
 */
public class PascalsTriangleII {

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<Integer> nums = solution.getRow(3);

    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  private static class Solution {
    HashMap<Position, Integer> hashMap = new HashMap<>();
    public final class Position {
      private int row, col;

      public Position(int row, int col) {
        this.row = row;
        this.col = col;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }

        Position position = (Position) o;

        if (row != position.row) {
          return false;
        }
        return col == position.col;
      }

      @Override
      public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
      }
    }

    public List<Integer> getRow(int index) {
      List<Integer> nums = new ArrayList<>();
      for (int i = 0; i <= index; i++) {
        nums.add(getNum(index, i));
      }

      return nums;
    }

    private int getNum(int i, int j) {
      Position position = new Position(i, j);

      if (hashMap.containsKey(position)) {
        return hashMap.get(position);
      }

      if (i == 0 || j == 0 || i == j) {
        hashMap.put(position, 1);
        return 1;
      }

      int num = getNum(i - 1, j - 1) + getNum(i - 1, j);
      hashMap.put(position, num);

      return num;
    }
  }
}
