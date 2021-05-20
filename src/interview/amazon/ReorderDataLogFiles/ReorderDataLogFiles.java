package interview.amazon.ReorderDataLogFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.ReorderDataLogFiles
 * @date 10/4/20
 * @comment: You have an array of logs. Each log is a space-delimited string of words. For each log,
 *     the first word in each log is an alphanumeric identifier. Then, either: Each word after the
 *     identifier will consist only of lowercase letters, or; Each word after the identifier will
 *     consist only of digits. We will call these two varieties of logs letter-logs and digit-logs.
 *     It is guaranteed that each log has at least one word after its identifier. Reorder the logs
 *     so that all of the letter-logs come before any digit-log. The letter-logs are ordered
 *     lexicographically ignoring identifiers, with the identifier used in case of ties. The
 *     digit-logs should be put in their original order. Input: logs = ["dig1 8 1 5 1","let1 art
 *     can","dig2 3 6","let2 own kit dig","let3 art zero"] Output: ["let1 art can","let3 art
 *     zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
public class ReorderDataLogFiles {
  public static void main(String[] args) {
    String[] logs = {
      "dig1 8 1 5 1", "let1 art can", "let4 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
    };

    logs = getOrderedLogs(logs);

    for (String log : logs) {
      System.out.println(log);
    }
  }

  private static String[] getOrderedLogs(String[] logs) {

    String[] orderedLogs = new String[logs.length];
    List<String> letterLogs = new ArrayList<>();
    List<String> digitsLogs = new ArrayList<>();

    for (String log : logs) {
      if (log.split(" ")[1].charAt(0) < 'a') {
        digitsLogs.add(log);
      }
      else {
        letterLogs.add(log);
      }
    }

    Collections.sort(letterLogs, (o1, o2) -> {
      String[] s1 = o1.split(" ");
      String[] s2 = o2.split(" ");

      int len1 = s1.length;
      int len2 = s2.length;

      for (int i = 1; i < Math.min(len1, len2); i++) {
        if (! s1[i].equals(s2[i])) {
          return s1[i].compareTo(s2[i]);
        }
      }

      return s1[0].compareTo(s2[0]);
    });

    int i = 0;
    for (String log : letterLogs) {
      orderedLogs[i++] = log;
    }

    for (String log : digitsLogs) {
      orderedLogs[i++] = log;
    }

    return orderedLogs;
  }
}
