package amazon.arraysAndStrings;

import java.util.HashMap;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/28/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/481/
 */
public class NumberToWords {
  /*public static void main(String[] args) {
    int num1 = 123;
    int num2 = 12345;
    int num3 = 1234567;
    int num4 = 1234567891;
    int num5 = 0;
    int num6 = 1000010;

    System.out.println(numberToWords(num1));
    System.out.println(numberToWords(num2));
    System.out.println(numberToWords(num3));
    System.out.println(numberToWords(num4));
    System.out.println(numberToWords(num5));
    System.out.println(numberToWords(num6));
  }

  private static String numberToWords(int num) {

    HashMap<Integer, String> numMap = new HashMap<>();
    numMap.put(100, "Hundred");
    numMap.put(1000, "Thousand");
    numMap.put(1000000, "Million");
    numMap.put(1000000000, "Billion");

    String result = "";
    if (num == 0) {
      return "Zero";
    } else if (num <= 9) {
      result = getSingleDigit(num);
    } else if (num <= 99) {
      if (num < 20) {
        result = getTwoDigitLessThan19(num);
      } else {
        int tens = num / 10;
        int rem = num - 10 * tens;
        result = getTens(tens * 10) + (rem == 0 ? "" : " " + getSingleDigit(rem));
      }
    }
    else if (num <= 999) {
      int hundreds = num / 100;
      int
    }
    return result;
  }

  private static String getTens(int num) {
    HashMap<Integer, String> numMap = new HashMap<>();

    numMap.put(20, "Twenty");
    numMap.put(30, "Thirty");
    numMap.put(40, "Forty");
    numMap.put(50, "Fifty");
    numMap.put(60, "Sixty");
    numMap.put(70, "Seventy");
    numMap.put(80, "Eighty");
    numMap.put(90, "Ninety");

    return num == 0 ? "" : numMap.get(num);
  }

  private static String getTwoDigitLessThan19(int num) {
    HashMap<Integer, String> numMap = new HashMap<>();

    numMap.put(10, "Ten");
    numMap.put(11, "Eleven");
    numMap.put(12, "Twelve");
    numMap.put(13, "Thirteen");
    numMap.put(14, "Fourteen");
    numMap.put(15, "Fifteen");
    numMap.put(16, "Sixteen");
    numMap.put(17, "Seventeen");
    numMap.put(18, "Eighteen");
    numMap.put(19, "Nineteen");

    return num == 0 ? "" : numMap.get(num);
  }

  private static String getSingleDigit(int num) {
    HashMap<Integer, String> numMap = new HashMap<>();
    numMap.put(1, "One");
    numMap.put(2, "Two");
    numMap.put(3, "Three");
    numMap.put(4, "Four");
    numMap.put(5, "Five");
    numMap.put(6, "Six");
    numMap.put(7, "Seven");
    numMap.put(8, "Eight");
    numMap.put(9, "Nine");

    return num == 0 ? "" : numMap.get(num);
  }*/
}
