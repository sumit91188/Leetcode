package explore.arrays101;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.arrays101
 * @date 5/5/21
 * @comment:
 *     https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
 */
public class MergeSortedArray {
  public static void main(String[] args) {
    int[] nums1 = new int[] {2,0};
    int[] nums2 = new int[] {1};

    Solution solution = new Solution();
    solution.merge(nums1, 1, nums2, 1);

    for (int num : nums1) {
      System.out.print(num + " ");
    }
  }

  private static class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
      if (n > 0) {
        int[] copiedNum1 = new int[m];

        for (int i = 0; i <= m - 1; i++) {
          copiedNum1[i] = nums1[i];
        }

        int num1Index = 0;
        int num2Index = 0;

        for (int i = 0; i <= m + n - 1; i++) {
          if (num2Index >= n || (num1Index <= m - 1 && copiedNum1[num1Index] < nums2[num2Index])) {
            nums1[i] = copiedNum1[num1Index++];
            continue;
          }
          else {
            nums1[i] = nums2[num2Index++];
          }
        }
      }
    }
  }
}
