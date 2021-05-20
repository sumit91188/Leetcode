package amazon.arraysAndStrings;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/28/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/499/
 */
public class ProductOfArray {
  public static void main(String[] args) {
    int[] nums1 = new int[] {1, 2, 3, 4};
    int[] nums2 = new int[] {-1, 1, 0, -3, 3};

    System.out.println(productExceptSelf(nums1));
    System.out.println(productExceptSelf(nums2));
  }

  private static int[] productExceptSelf(int[] nums) {
    /*int[] result = new int[nums.length];
    int product = 0;
    boolean hasZero = false;

    for (int i = 0; i <= nums.length - 1; i++) {
      if (nums[i] == 0) {
        if (hasZero) {
          product = 0;
          break;
        }
        hasZero = true;
      } else {
        if (product == 0) {
          product++;
        }
        product *= nums[i];
      }
    }

    for (int i = 0; i <= nums.length - 1; i++) {
      if (hasZero) {
        if (nums[i] == 0) {
          result[i] = product;
        } else {
          result[i] = 0;
        }
      } else {
        result[i] = product / nums[i];
      }
    }

    return result;*/

    int[] result = new int[nums.length];
    int[] leftProduct = new int[nums.length];
    int[] rightProduct = new int[nums.length];

    leftProduct[0] = 1;
    for (int i = 1; i <= nums.length - 1; i++) {
      leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
    }

    rightProduct[nums.length - 1] = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
    }

    for (int i = 0; i <= nums.length - 1; i++) {
      result[i] = leftProduct[i] * rightProduct[i];
    }

    return result;
  }
}
