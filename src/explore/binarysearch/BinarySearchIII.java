package explore.binarysearch;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.binarysearch
 * @date 5/17/21
 * @comment: https://leetcode.com/explore/learn/card/binary-search/135/template-iii/936/
 * Template #3 is another unique form of Binary Search.
 * It is used to search for an element or condition which requires accessing the current index and its immediate left and right neighbor's index in the array.
 */
public class BinarySearchIII {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 12;

        Solution solution = new Solution();
        int index = solution.search(nums, target);
        System.out.println(index);
    }

    private static class Solution {

        public int search(int[] nums, int target) {
            int leftIndex = 0;
            int rightIndex = nums.length -1;

            while (leftIndex + 1 < rightIndex) {
                //to prevent leftIndex + rightIndex to overflow
                int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
                if (nums[midIndex] > target) {
                    rightIndex = midIndex;
                } else if (nums[midIndex] < target) {
                    leftIndex = midIndex;
                } else {
                    return midIndex;
                }
            }

            if (nums[leftIndex] == target) return leftIndex;
            if (nums[rightIndex] == target) return rightIndex;
            return -1;
        }
    }
}
