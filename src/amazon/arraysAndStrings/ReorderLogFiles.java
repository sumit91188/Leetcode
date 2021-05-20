package amazon.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.arraysAndStrings
 * @date 4/29/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2974/
 */
public class ReorderLogFiles {
  public static void main(String[] args) {
    String[] logs1 =
        new String[] {
          "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
        };
    String[] logs2 =
        new String[] {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};

    System.out.println(reorderLogFiles(logs1));
    System.out.println(reorderLogFiles(logs2));
  }

  private static String[] reorderLogFiles(String[] logs) {
    /*HashMap<String, List<String>> letterLogsMap = new HashMap<>();
    List<String> letterLogs = new ArrayList<>();
    List<String> digitsLogs = new ArrayList<>();

    for (String log : logs) {
      String[] logContent = log.split("\\s+");
      if (Character.isDigit(logContent[1].charAt(0))) {
        digitsLogs.add(log);
      }
      else {
        for (int i = 1; i <= Math.max())
      }
    }*/

    Comparator<String> comparator = (log1, log2) -> {
      String[] log1Content = log1.split(" ", 2);
      String[] log2Content = log2.split(" ", 2);

      boolean isLog1DigitLog = Character.isDigit(log1Content[1].charAt(0));
      boolean isLog2DigitLog = Character.isDigit(log2Content[1].charAt(0));

      if (! isLog1DigitLog && ! isLog2DigitLog) {
        int compare = log1Content[1].compareTo(log2Content[1]);
        if (compare != 0) {
          return compare;
        }
        return log1Content[0].compareTo(log2Content[0]);
      }
      else if (isLog1DigitLog && ! isLog2DigitLog) {
        return 1;
      }
      else if (! isLog1DigitLog && isLog2DigitLog) {
        return -1;
      }
      else {
        return 0;
      }
    };

    Arrays.sort(logs, comparator);
    return logs;
  }
}
