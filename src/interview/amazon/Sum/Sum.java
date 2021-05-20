package interview.amazon.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium
 * @date 10/4/20
 * @comment: Given an array n integers, are there elements a, b, c in array such that sum of (a,b,c)
 *     equals to a particular target X? This Problem can easily be solved in naive O(n³) time
 *     complexity. But how do you Solve it in O(n²). With follow up questions like How will you
 *     Solve if you want unique Triplets?
 */
public class Sum {
  public static void main(String[] args) {
    int[] numbers = {0,0,1,1,1,2,3,4,4,4,4,5,6,7,8,9,10,0,1,2,3};
    int x = 10;

    List<List<Integer>> integerListsList = findTriplets(numbers, x);
    for (List<Integer> i : integerListsList) {
      for (int j : i) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

  private static List<List<Integer>> findTriplets(int[] numbers, int x) {

    List<List<Integer>> result = new ArrayList<>();
    TreeSet<String> treeSet = new TreeSet<>();

    Arrays.sort(numbers);

    int leftIndex;
    int rightIndex;

    for (int i = 0; i < numbers.length - 2; i++) {
      leftIndex = i + 1;
      rightIndex = numbers.length - 1;

      while (leftIndex < rightIndex) {
        int sum = numbers[i] + numbers[leftIndex] + numbers[rightIndex];
        if (sum < x) {
          leftIndex++;
        }
        else if (sum == x) {
          String resultStr = numbers[i] + ":" + numbers[leftIndex] + ":" + numbers[rightIndex];

          if (! treeSet.contains(resultStr)) {
            List<Integer> tripplet = new ArrayList<>();
            tripplet.add(numbers[i]);
            tripplet.add(numbers[leftIndex]);
            tripplet.add(numbers[rightIndex]);
            result.add(tripplet);
          }
          treeSet.add(resultStr);
          leftIndex++;
          rightIndex--;
        }
        else {
          rightIndex--;
        }
      }
    }

    return result;
  }
}
