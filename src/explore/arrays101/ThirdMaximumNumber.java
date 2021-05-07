package explore.arrays101;

import java.util.Collections;
import java.util.HashSet;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/7/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/
 */
public class ThirdMaximumNumber {
  public static void main(String[] args) {
    int[] nums = new int[] {2,2,3,1};

    Solution solution = new Solution();
    int thirdMax = solution.thirdMax(nums);

    System.out.println(thirdMax);
  }

  private static class Solution {

    public int thirdMax(int[] nums) {
      HashSet<Integer> max3 = new HashSet<>();

      for (int num : nums) {
        max3.add(num);
        if (max3.size() > 3) {
          max3.remove(Collections.min(max3));
        }
      }

      if (max3.size() == 3) {
        return Collections.min(max3);
      }

      return Collections.max(max3);
    }
  }
}
