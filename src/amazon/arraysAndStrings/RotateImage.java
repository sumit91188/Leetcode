package amazon.arraysAndStrings;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/26/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2969/
 */
public class RotateImage {
  public static void main(String[] args) {
    int[][] matrix1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    int[][] matrix2 = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
    int[][] matrix3 = new int[][]{{1}};
    int[][] matrix4 = new int[][]{{1,2,},{3,4}};

    rotate(matrix1);
    rotate(matrix2);
    rotate(matrix3);
    rotate(matrix4);

    System.out.println(matrix1);
    System.out.println(matrix2);
    System.out.println(matrix3);
    System.out.println(matrix4);
  }

  private static void rotate(int[][] matrix) {
    if (matrix.length != matrix[0].length) {
      throw new RuntimeException("Invalid matrix");
    }

    int N = matrix.length;

    for (int i = 0; i <= (N/2 - 1); i++) {
      for (int j = i; j <= N - i - 2; j++) {
        /*int temp = matrix[N - j - 1][i];
        matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1];
        matrix[N - i - 1][N - j - 1] = matrix[j][N - i - 1];
        matrix[j][N - i - 1] = matrix[i][j];
        matrix[i][j] = temp;*/
        int temp = matrix[i][j];
        matrix[i][j] = matrix[N - j -1][i];
        matrix[N - j -1][i] = matrix[N - i - 1][N - j - 1];
        matrix[N - i - 1][N - j - 1] = matrix[j][N - i - 1];
        matrix[j][N - i - 1] = temp;
      }
    }
  }
}
