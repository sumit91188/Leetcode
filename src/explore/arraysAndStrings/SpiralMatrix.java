package explore.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sumit Deo
 * @Date 7/29/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        Solution solution = new Solution();
        List<Integer> nums = solution.spiralOrder(matrix);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> nums = new ArrayList<>();

            if (matrix != null && matrix.length != 0) {
                int M = matrix.length;
                int N = matrix[0].length;

                int r1 = 0;
                int r2 = M - 1;

                int c1 = 0;
                int c2 = N - 1;

                while (r1 <= r2 && c1 <= c2) {
                    for (int c = c1; c <= c2; c++) {
                        nums.add(matrix[r1][c]);
                    }

                    for (int r = r1 + 1; r <= r2; r++) {
                        nums.add(matrix[r][c2]);
                    }

                    if (r1 < r2 && c1 < c2) {
                        for (int c = c2 - 1; c > c1; c--) {
                            nums.add(matrix[r2][c]);
                        }

                        for (int r = r2; r > r1; r--) {
                            nums.add(matrix[r][c1]);
                        }
                    }

                    r1++;
                    r2--;
                    c1++;
                    c2--;
                }
            }

            return nums;
        }
    }
}
