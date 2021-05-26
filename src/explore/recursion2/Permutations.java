package explore.recursion2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sumit Deo
 * @Date 5/23/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/permutations/solution/
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Solution solution = new Solution();
        List<List<Integer>> permutations = solution.permute(nums);

        for (List<Integer> permutation : permutations) {
            for (int num : permutation) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> permutations = new ArrayList<>();
            List<Integer> numList = new ArrayList<>();

            for (int num : nums) {
                numList.add(num);
            }

            int numLen = numList.size();

            backtrack(numLen, numList, permutations, 0);

            return permutations;
        }

        private void backtrack(int numLen, List<Integer> numList, List<List<Integer>> permutations, int first) {
            if (first == numLen) {
                permutations.add(new ArrayList<>(numList));
            }

            for (int i = first; i <= numLen - 1; i++) {
                Collections.swap(numList, first, i);

                backtrack(numLen, numList, permutations, first + 1);

                Collections.swap(numList, first, i);
            }
        }
    }
}
