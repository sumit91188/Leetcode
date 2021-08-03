package explore.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sumit Deo
 * @Date 7/29/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;

        Solution solution = new Solution();
        List<List<Integer>> triangle = solution.generate(numRows);

        for (List<Integer> col : triangle) {
            for (int element : col) {
                System.out.print(element + " ");
            }

            System.out.println();
        }
    }

    private static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<>();

            if (numRows > 0) {
                List<Integer> column = new ArrayList<>();
                column.add(1);
                triangle.add(column);

                for (int i = 1; i < numRows; i++) {
                    List<Integer> previousColumn = triangle.get(i-1);
                    column = new ArrayList<>();

                    column.add(1);

                    for (int j = 1; j < previousColumn.size(); j++) {
                        column.add(previousColumn.get(j-1) + previousColumn.get(j));
                    }

                    column.add(1);

                    triangle.add(column);
                }
            }

            return triangle;
        }
    }
}
