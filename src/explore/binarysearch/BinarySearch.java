package explore.binarysearch;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.binarysearch
 * @date 5/17/21
 * @comment: https://leetcode.com/explore/learn/card/binary-search/138/background/1038/
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -9999 <= nums[i], target <= 9999
 * All the integers in nums are unique.
 * nums is sorted in an ascending order.
 */
public class BinarySearch {

  public static void main(String[] args) {
    int[] nums = new int[] {-1,0,3,5,9,12};
    int target = 9;

    Solution solution = new Solution();
    int index = solution.search(nums, target);
    System.out.println(index);
  }

  private static class Solution {

    public int search(int[] nums, int target) {
      int leftIndex = 0;
      int rightIndex = nums.length - 1;

      while (leftIndex <= rightIndex) {
        //to prevent leftIndex + rightIndex to overflow
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        if (nums[midIndex] > target) {
          rightIndex = midIndex - 1;
        }
        else if (nums[midIndex] < target) {
          leftIndex = midIndex + 1;
        }
        else {
          return midIndex;
        }
      }

      return -1;
    }
  }
}
