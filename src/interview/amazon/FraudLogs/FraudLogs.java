package interview.amazon.FraudLogs;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.FraudLogs
 * @date 10/8/20
 * @comment:
 */
public class FraudLogs {
  public static void main(String[] args) {
    String[] input =
        new String[] {
          "345366 89921 45",
          "029323 38239 23",
          "38239 345366 15",
          "029323 38239 77",
          "345366 38239 23",
          "029323 345366 13",
          "38239 38239 23"
        };
    String[] users = getFraudIds(input, 3);

    for (String user : users) {
      System.out.print(user + " ");
    }
  }

  private static String[] getFraudIds(String[] logs, int threshold) {
    HashMap<String, Integer> userCount = new HashMap<>();
    for (String log : logs) {
      String[] data = log.split(" ");
      userCount.put(data[0], userCount.getOrDefault(data[0], 0) + 1);
      if (data[0].equals(data[1])) {
        continue;
      }
      userCount.put(data[1], userCount.getOrDefault(data[1], 0) + 1);
    }

    List<String> users =
        userCount.entrySet().stream()
            .sorted(Entry.<String, Integer>comparingByValue().reversed())
            .map(Entry::getKey)
            .limit(threshold)
            .collect(Collectors.toList());

    String[] result = new String[3];
    result = users.toArray(result);
    return result;
  }
}
