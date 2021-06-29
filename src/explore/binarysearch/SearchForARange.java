package explore.binarysearch;

/**
 * @author Sumit Deo
 * @Date 6/24/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/135/template-iii/944/
 */
public class SearchForARange {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        Solution solution = new Solution();
        int[] range = solution.searchRange(nums, 11);

        for (int i: range) {
            System.out.print(i + " ");
        }
    }

    private static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int startIndex = getIndex(nums, target, true);
            if (startIndex == -1) {
                return new int[]{-1, -1};
            }

            int endIndex = getIndex(nums, target, false);

            return new int[]{startIndex, endIndex};
        }

        private int getIndex(int[] nums, int target, boolean isFirstIndex) {
            int leftIndex = 0;
            int rightIndex = nums.length - 1;

            while (leftIndex <= rightIndex) {
                int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

                if (nums[midIndex] < target) {
                    leftIndex = midIndex + 1;
                }
                else if (nums[midIndex] > target) {
                    rightIndex = midIndex - 1;
                }
                else {
                    if (isFirstIndex) {
                        if (midIndex == leftIndex || nums[midIndex - 1] != target) {
                            return midIndex;
                        }
                        rightIndex = midIndex - 1;
                    }
                    else {
                        if (midIndex == rightIndex || nums[midIndex + 1] != target) {
                            return midIndex;
                        }
                        leftIndex = midIndex + 1;
                    }
                }
            }
            return -1;
        }
    }
}
