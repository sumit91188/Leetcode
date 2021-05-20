package amazon.arraysAndStrings;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/30/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2975/
 */
public class TrappingRainWater {
  public static void main(String[] args) {
    int[] height1 = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(height1));

    int[] height2 = new int[] {4, 2, 0, 3, 2, 5};
    System.out.println(trap(height2));
  }

  private static int trap(int[] height) {
    int left = 0;
    int right = height.length - 1;

    int rightMax = 0;
    int leftMax = 0;
    int result = 0;

    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          result += (leftMax - height[left]);
        }
        left++;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          result += (rightMax - height[right]);
        }
        right--;
      }
    }
    return result;
  }
}
