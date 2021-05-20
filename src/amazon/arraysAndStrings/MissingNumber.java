package amazon.arraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/28/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2971/
 */
public class MissingNumber {
  public static void main(String[] args) {
    int[] nums1 = new int[]{3,0,1};
    int[] nums2 = new int[]{0,1};
    int[] nums3 = new int[]{9,6,4,2,3,5,7,0,1};
    int[] nums4 = new int[]{0};
    int[] nums5 = new int[]{};

    System.out.println(missingNumber(nums1));
    System.out.println(missingNumber(nums2));
    System.out.println(missingNumber(nums3));
    System.out.println(missingNumber(nums4));
    System.out.println(missingNumber(nums5));
  }

  private static int missingNumber(int[] nums) {
    HashSet<Integer> numSet = new HashSet<>();

    int distNum = nums.length;

    for (int i = 0; i <= distNum - 1; i++) {
      numSet.add(nums[i]);
    }

    for (int i = 0; i <= distNum; i++) {
      if (! numSet.contains(i)) {
        return i;
      }
    }
    return 0;
  }
}
