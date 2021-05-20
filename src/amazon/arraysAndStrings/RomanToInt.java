package amazon.arraysAndStrings;

import java.util.HashMap;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/25/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2965/
 */
public class RomanToInt {
  public static void main(String[] args) {
    String num1 = "III"; // 3
    String num2 = "IV"; // 4
    String num3 = "IX"; // 9
    String num4 = "LVIII"; // 58
    String num5 = "MCMXCIV"; // 1994
    String num6 = "MDCXCV";

    /*System.out.println(romanToInt(num1));
    System.out.println(romanToInt(num2));
    System.out.println(romanToInt(num3));
    System.out.println(romanToInt(num4));
    System.out.println(romanToInt(num5));*/
    System.out.println(romanToInt(num6));
  }

  private static int romanToInt(String romanStr) {

    HashMap<String, Integer> romanNumMap = new HashMap<>();
    romanNumMap.put("I", 1);
    romanNumMap.put("V", 5);
    romanNumMap.put("X", 10);
    romanNumMap.put("L", 50);
    romanNumMap.put("C", 100);
    romanNumMap.put("D", 500);
    romanNumMap.put("M", 1000);
    romanNumMap.put("IV", 4);
    romanNumMap.put("IX", 9);
    romanNumMap.put("XL", 40);
    romanNumMap.put("XC", 90);
    romanNumMap.put("CD", 400);
    romanNumMap.put("CM", 900);

    if (romanNumMap.containsKey(romanStr)) {
      return romanNumMap.get(romanStr);
    }

    int i = 0;
    int num = 0;
    String currentChar, nextChar;
    int currentVal, nextVal;

    while (i <= romanStr.length() - 1) {
      nextVal = Integer.MIN_VALUE;
      currentChar = romanStr.substring(i, i + 1);
      currentVal = romanNumMap.get(currentChar);
      if (i <= romanStr.length() - 2) {
        nextChar = romanStr.substring(i + 1, i + 2);
        nextVal = romanNumMap.get(nextChar);
      }

      if (currentVal < nextVal) {
        num += nextVal - currentVal;
        i += 2;

      } else {
        num += currentVal;
        i++;
      }
    }
    return num;
  }
}
