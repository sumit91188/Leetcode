package amazon.arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/22/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2964/
 */
public class IntToRoman {
  public static void main(String[] args) {
    int num1 = 3;
    int num2 = 4;
    int num3 = 9;
    int num4 = 58;
    int num5 = 1994;

    System.out.println(intToRoman(num1));
    System.out.println(intToRoman(num2));
    System.out.println(intToRoman(num3));
    System.out.println(intToRoman(num4));
    System.out.println(intToRoman(num5));
  }

  private static String intToRoman(int num) {
    HashMap<Integer, String> romanNumMap = new HashMap<>();
    romanNumMap.put(1, "I");
    romanNumMap.put(5, "V");
    romanNumMap.put(10, "X");
    romanNumMap.put(50, "L");
    romanNumMap.put(100, "C");
    romanNumMap.put(500, "D");
    romanNumMap.put(1000, "M");
    romanNumMap.put(4, "IV");
    romanNumMap.put(9, "IX");
    romanNumMap.put(40, "XL");
    romanNumMap.put(90, "XC");
    romanNumMap.put(400, "CD");
    romanNumMap.put(900, "CM");

    if (romanNumMap.containsKey(num)) {
      return romanNumMap.get(num);
    }

    List<Integer> sortedRomanNums = new ArrayList(romanNumMap.keySet());
    Collections.sort(sortedRomanNums, Collections.reverseOrder());

    String romanString = "";

    for (int i = 0; i < sortedRomanNums.size() && num > 0; i++) {
      if (num >= sortedRomanNums.get(i)) {
        romanString += romanNumMap.get(sortedRomanNums.get(i));
        num = num - sortedRomanNums.get(i);
        i--;
      }
    }

    return romanString;
  }
}
