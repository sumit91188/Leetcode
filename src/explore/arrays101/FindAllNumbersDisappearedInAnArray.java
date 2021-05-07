package explore.arrays101;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/7/21
 * @comment: https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3270/
 */
public class FindAllNumbersDisappearedInAnArray {
  public static void main(String[] args) {
    int[] nums = new int[] {4, 3, 2, 7, 8, 2, 3, 1};

    Solution solution = new Solution();
    List<Integer> disappearedNumbers = solution.findDisappearedNumbers(nums);

    for (int num : disappearedNumbers) {
      System.out.print(num + " ");
    }
  }

  private static class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
      HashSet<Integer> uniqueNums = new HashSet<>();
      for (int num : nums) {
        uniqueNums.add(num);
      }

      List<Integer> disappearedNumbers = new ArrayList<>();
      for (int i = 1; i <= nums.length; i++) {
        if (! uniqueNums.contains(i)) {
          disappearedNumbers.add(i);
        }
      }

      return disappearedNumbers;
    }
  }
}
