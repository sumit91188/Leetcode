package explore.arraysAndStrings;

import java.util.*;

/**
 * @author Sumit Deo
 * @Date 7/28/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/diagonal-traverse/
 * Better Solution: https://leetcode.com/problems/diagonal-traverse/discuss/581868/Easy-Python-NO-DIRECTION-CHECKING
 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Solution solution = new Solution();
        int[] nums = solution.findDiagonalOrder(matrix);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0];
            }

            int M = matrix.length;
            int N = matrix[0].length;

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (! map.containsKey(i + j)) {
                        map.put(i + j, new ArrayList<>());
                    }
                    map.get(i + j).add(matrix[i][j]);
                }
            }

            ArrayList<Integer> nums = new ArrayList<>();
            for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
                if (entry.getKey() % 2 == 0) {
                    ArrayList<Integer> reversedList = entry.getValue();
                    Collections.reverse(reversedList);
                    nums.addAll(reversedList);
                }
                else {
                    nums.addAll(entry.getValue());
                }
            }

            int[] result = new int[M*N];

            for (int i = 0; i < nums.size(); i++) {
                result[i] = nums.get(i);
            }

            return result;
        }
    }
}
