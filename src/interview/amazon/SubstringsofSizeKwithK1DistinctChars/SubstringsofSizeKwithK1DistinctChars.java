package interview.amazon.SubstringsofSizeKwithK1DistinctChars;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.SubstringsofSizeKwithK1DistinctChars
 * @date 10/5/20
 * @comment:
 */
public class SubstringsofSizeKwithK1DistinctChars {
  public static void main(String[] args) {
    String input = "democracy";
    int num = 5;

    List<String> results = solve(input, num);

    for (String str : results) {
      System.out.print(str + " ");
    }
  }

  private static List<String> solve(String input, int num) {
    if (num > input.length()) {
      throw new RuntimeException("Number should be less than the length of the String");
    }

    List<String> strings = new ArrayList<>();
    for (int i = 0; i <= input.length() - num; i++) {
      strings.add(input.substring(i, i + num));
    }

    List<String> result = new ArrayList<>();
    for (String str : strings) {
      if (str.chars().distinct().count() == num - 1) {
        result.add(str);
      }
    }
    return result;
  }
}
