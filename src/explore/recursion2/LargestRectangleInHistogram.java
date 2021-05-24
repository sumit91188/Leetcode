package explore.recursion2;

/**
 * @author Sumit Deo
 * @Date 5/23/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2901/
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(heights));
    }

    private static class Solution {
        public int largestRectangleArea(int[] heights) {
            return helper(heights, 0, heights.length - 1);
        }

        private int helper(int[] heights, int leftIndex, int rightIndex) {
            if (leftIndex > rightIndex) {
                return 0;
            }

            int smallestHeightIndex = leftIndex;
            for (int i = leftIndex; i <= rightIndex; i++) {
                if (heights[smallestHeightIndex] > heights[i]) {
                    smallestHeightIndex = i;
                }
            }

            return Math.max(heights[smallestHeightIndex] * (rightIndex - leftIndex + 1),
                    Math.max(helper(heights, leftIndex, smallestHeightIndex - 1),
                    helper(heights, smallestHeightIndex + 1, rightIndex)));
        }
    }
}
