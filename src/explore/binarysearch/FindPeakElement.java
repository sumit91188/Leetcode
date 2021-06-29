package explore.binarysearch;

/**
 * @author Sumit Deo
 * @Date 6/3/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,5,5,4};
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement(nums));
    }

    private static class Solution {
        public int findPeakElement(int[] nums) {
            /*for (int i = 0; i <= nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            }
            return nums.length - 1;*/  // O(n)

            int left = 0;
            int right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }
}
