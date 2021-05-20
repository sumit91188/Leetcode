package amazon.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/25/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2966/
 */
public class ThreeSum {
  public static void main(String[] args) {
    int[] nums1 = new int[] {-1,0,1,2,-1,-4};
    int[] nums2 = new int[] {};
    int[] nums3 = new int[] {0};

    System.out.println(threeSum(nums1));
    System.out.println(threeSum(nums2));
    System.out.println(threeSum(nums3));
  }

  private static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    HashSet<List<Integer>> results = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      int target = nums[i];
      int leftIndex = i + 1;
      int rightIndex = nums.length - 1;

      while (leftIndex < rightIndex) {
        int sum = nums[leftIndex] + nums[rightIndex];
        if (sum + target == 0) {
          List<Integer> result = new ArrayList<>();
          result.add(nums[i]);
          result.add(nums[leftIndex]);
          result.add(nums[rightIndex]);
          results.add(result);
          leftIndex++;
          rightIndex--;
        }
        else if (sum + target < 0) {
          leftIndex++;
        }
        else {
          rightIndex--;
        }
      }
    }
    return new ArrayList<>(results);
  }

  /*private static List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>> results = new HashSet<>();
    HashMap<Integer, Integer> numMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      numMap.put(nums[i], i);
    }

    for (int i = 0; i <= nums.length - 2; i++) {
      for (int j = i + 1; j <= nums.length - 1; j++) {
        if (numMap.containsKey(-(nums[i] + nums[j])) && numMap.get(-(nums[i] + nums[j])) > j) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j]);
          list.add(-(nums[i] + nums[j]));
          Collections.sort(list);
          results.add(list);
        }
      }
    }
    return new ArrayList<>(results);
  }*/
}
