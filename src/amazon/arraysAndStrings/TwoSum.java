package amazon.arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/20/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/508/
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] nums = new int[]{3,2,4};
    int target = 6;


    int[] result = twoSum(nums, target);

    for (int i : result) {
      System.out.print(i + " ");
    }
  }

  private static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> numMap = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      numMap.put(nums[i], i);
    }
    Arrays.sort(nums);
    int leftNum = 0;
    int rightNum = nums.length - 1;

    while (leftNum < rightNum) {
      int sum = nums[leftNum] + nums[rightNum];
      if (target == sum) {
        return new int[] {numMap.get(nums[leftNum]), numMap.get(nums[rightNum])};
      }
      else if (sum < target) {
        leftNum++;
      }
      else {
        rightNum--;
      }
    }
    throw new RuntimeException("No such pair!");
  }

  /*private static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> numMap = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      numMap.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      if (numMap.containsKey(target - nums[i]) && numMap.get(target - nums[i]) != i) {
        return new int[]{i, numMap.get(target - nums[i])};
      }
    }

    throw new RuntimeException("No such pair!");
  }*/


}
