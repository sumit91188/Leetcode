package amazon.arraysAndStrings;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/21/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2962/
 */
public class Atoi {
  public static void main(String[] args) {
    String inputStr1 = "42";
    String inputStr2 = "   -42";
    String inputStr3 = "4193 with words";
    String inputStr4 = "words and 987";
    String inputStr5 = "-91283472332";
    String inputStr6 = "9223372036854775808";
    String inputStr7 = "  -0012a42";

    System.out.println(getAtoiNumber(inputStr1));
    System.out.println(getAtoiNumber(inputStr2));
    System.out.println(getAtoiNumber(inputStr3));
    System.out.println(getAtoiNumber(inputStr4));
    System.out.println(getAtoiNumber(inputStr5));
    System.out.println(getAtoiNumber(inputStr6));
    System.out.println(getAtoiNumber(inputStr7));
  }

  private static int getAtoiNumber(String s) {
    char sign = '+';
    Long atoiNum = 0L;

    int i = 0;
    while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
      i++;
    }

    if (i < s.length() && s.charAt(i) == '-') {
      sign = '-';
      i++;
    }
    else if (i < s.length() && s.charAt(i) == '+') {
      i++;
    }

    boolean isOverflown = false;

    while (i < s.length() && Character.isDigit(s.charAt(i))) {
      atoiNum = atoiNum * 10 + Character.getNumericValue(s.charAt(i));
      if (atoiNum > Integer.MAX_VALUE && sign == '+') {
        atoiNum = Long.valueOf(Integer.MAX_VALUE);
        isOverflown = true;
        break;
      }
      else if (atoiNum > Integer.MAX_VALUE && sign == '-') {
        atoiNum = Long.valueOf(Integer.MIN_VALUE);
        isOverflown = true;
        break;
      }
      i++;
    }

    if (!isOverflown && sign == '-') {
      atoiNum *= -1;
    }

    return Math.toIntExact(atoiNum);
  }
}
