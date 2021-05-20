package amazon.arraysAndStrings;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/21/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2963/
 */
public class ContainerWithMostWater {
  public static void main(String[] args) {
    int[] input1 = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int[] input2 = new int[] {1, 1};
    int[] input3 = new int[] {4, 3, 2, 1, 4};
    int[] input4 = new int[] {1, 2, 1};
    int[] input5 = new int[] {2, 3, 4, 5, 18, 17, 6};

    System.out.println(maxArea(input1));
    System.out.println(maxArea(input2));
    System.out.println(maxArea(input3));
    System.out.println(maxArea(input4));
    System.out.println(maxArea(input5));
  }

  private static int maxArea(int[] height) {
    int maxArea = Integer.MIN_VALUE;
    int leftLn = 0;
    int rightLn = height.length - 1;

    while (leftLn < rightLn) {
      maxArea = Math.max(maxArea, (rightLn - leftLn) * (Math.min(height[leftLn], height[rightLn])));
      if (height[leftLn] < height[rightLn]) {
        leftLn++;
      } else {
        rightLn--;
      }
    }
    return maxArea;
  }
}
