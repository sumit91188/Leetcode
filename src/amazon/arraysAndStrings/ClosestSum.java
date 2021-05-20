package amazon.arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/26/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2967/
 */
public class ClosestSum {
  public static void main(String[] args) {
    int[] nums = new int[] {1,1,1,0};
    int target = -100;

    System.out.println(threeSumClosest(nums, target));
  }

  private static int threeSumClosest(int[] nums, int target) {
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
