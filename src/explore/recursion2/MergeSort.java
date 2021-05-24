package explore.recursion2;

import java.util.Arrays;

/**
 * @author Sumit Deo
 * @Date 5/20/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2868/
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[] {4,3,5,7,2,8,9,6,1,9};

        Solution solution = new Solution();
        int[] sortedNums = solution.sort(nums);

        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
    }

    private static class Solution {
        public int[] sort(int[] nums) {
            if (nums.length <= 1) {
                return nums;
            }

            int pivot = nums.length / 2;

            int[] leftNums = sort(Arrays.copyOfRange(nums, 0, pivot));
            int[] rightNums = sort(Arrays.copyOfRange(nums, pivot, nums.length));

            return merge(leftNums, rightNums);
        }

        private int[] merge(int[] leftNums, int[] rightNums) {
            int[] nums = new int[leftNums.length + rightNums.length];
            int leftNumsIndex = 0;
            int rightNumsIndex = 0;
            int numsIndex = 0;

            while (leftNumsIndex < leftNums.length && rightNumsIndex < rightNums.length) {
                if (leftNums[leftNumsIndex] <= rightNums[rightNumsIndex]) {
                    nums[numsIndex++] = leftNums[leftNumsIndex++];
                }
                else {
                    nums[numsIndex++] = rightNums[rightNumsIndex++];
                }
            }

            while (leftNumsIndex < leftNums.length) {
                nums[numsIndex++] = leftNums[leftNumsIndex++];
            }

            while (rightNumsIndex < rightNums.length) {
                nums[numsIndex++] = rightNums[rightNumsIndex++];
            }

            return nums;
        }
    }
}
