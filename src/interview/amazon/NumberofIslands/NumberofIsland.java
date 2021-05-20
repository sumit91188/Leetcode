package interview.amazon.NumberofIslands;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.NumberofIslands
 * @date 10/5/20
 * @comment:
 */
public class NumberofIsland {
  public static void main(String[] args) {
    char[][] grid = {
      {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '1', '1'}
    };

    System.out.println(numberOfIslands(grid));
  }

  private static int numberOfIslands(char[][] grid) {

    if(grid==null || grid.length==0||grid[0].length==0)
      return 0;

    int result = 0;
    int l = grid.length;
    int h = grid[0].length;

    for (int i = 0; i < l; i++) {
      for (int j = 0; j < h; j++) {
        if (grid[i][j] == '1') {
          result++;
          merge(grid, i, j);
        }
      }
    }

    return result;
  }

  private static void merge(char[][] grid, int i, int j) {
    int l = grid.length;
    int h = grid[0].length;
    if (i < 0 || i >= l || j < 0 || j >= h || grid[i][j] != '1') {
      return;
    }

    grid[i][j] = 'X';
    merge(grid, i - 1, j);
    merge(grid, i, j - 1);
    merge(grid, i + 1, j);
    merge(grid, i, j + 1);
  }
}
