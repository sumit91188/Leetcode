package amazon.arraysAndStrings;

import java.util.Arrays;

/**
 * @author Sumit Deo
 * @Date 5/25/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2967/
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums1 = new int[] {-1,2,1,-4};

        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums1, 1));
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int minDiff = Integer.MAX_VALUE;
            int sum;

            for (int i = 0; i <= nums.length - 1; i++) {
                int leftIndex = i + 1;
                int rightIndex = nums.length - 1;
                while (leftIndex < rightIndex) {
                    sum = nums[i] + nums[leftIndex] + nums[rightIndex];
                    if (target == sum) {
                        return target;
                    }
                    if (Math.abs(target - sum) < Math.abs(minDiff)) {
                        minDiff = target - sum;
                    }
                    if (sum < target) {
                        leftIndex++;
                    }
                    else {
                        rightIndex--;
                    }
                }
            }
            return target - minDiff;

        }
    }
}
