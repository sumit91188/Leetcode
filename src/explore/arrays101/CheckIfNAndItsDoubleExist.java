package explore.arrays101;

import java.util.HashMap;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/6/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
 */
public class CheckIfNAndItsDoubleExist {
  public static void main(String[] args) {
    int[] nums = new int[] {10,2,8,3};

    Solution solution = new Solution();
    boolean flag = solution.checkIfExist(nums);

    System.out.println(flag);
  }

  private static class Solution {

    public boolean checkIfExist(int[] nums) {
      HashMap<Integer, Integer> numsMap = new HashMap<>();

      for (int i = 0; i <= nums.length - 1; i++) {
        numsMap.put(nums[i], i);
      }

      for (int i = 0; i <= nums.length - 1; i++) {
        if (numsMap.containsKey(nums[i] * 2) && numsMap.get(nums[i]) != i) {
          return true;
        }
      }
      return false;
    }
  }
}
