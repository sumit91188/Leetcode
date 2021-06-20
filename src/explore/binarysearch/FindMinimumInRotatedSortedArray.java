package explore.binarysearch;

/**
 * @author Sumit Deo
 * @Date 6/9/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        Solution solution = new Solution();

        System.out.println(solution.findMin(nums));
    }

    private static class Solution {
        public int findMin(int[] nums) {
            int leftIndex = 0;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {
                int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

                if (nums[leftIndex] < nums[rightIndex] && nums[leftIndex] < nums[midIndex]){}
            }
            return 0;
        }
    }
}
