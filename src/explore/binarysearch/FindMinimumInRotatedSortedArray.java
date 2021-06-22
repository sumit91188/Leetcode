package explore.binarysearch;

/**
 * @author Sumit Deo
 * @Date 6/9/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,1};
        Solution solution = new Solution();

        System.out.println(solution.findMin(nums));
    }

    private static class Solution {
        public int findMin(int[] nums) {
            int leftIndex = 0;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {
                int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

                if (nums[midIndex] < nums[rightIndex]) {
                    rightIndex = midIndex;
                }
                else {
                    leftIndex = midIndex + 1;
                }
            }
            return nums[leftIndex];
        }
    }
}
