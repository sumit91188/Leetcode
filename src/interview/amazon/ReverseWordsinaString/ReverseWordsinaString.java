package interview.amazon.ReverseWordsinaString;

import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.ReverseWordsinaString
 * @date 10/5/20
 * @comment:
 */
public class ReverseWordsinaString {
  public static void main(String[] args) {
    String input = "  hello   world  bye   ";
    System.out.println(reverseWords(input));
  }

  private static String reverseWords(String input) {
    String[] words = input.trim().split("\\s+");
    Stack<String> strings = new Stack<>();

    for (String word : words) {
      strings.push(word);
    }

    String result = "";

    while (! strings.empty()) {
      result += strings.pop() + " ";
    }
    return result.trim();
  }
}
