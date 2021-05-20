package interview.amazon.KindleFeatures;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.KindleFeatures
 * @date 10/7/20
 * @comment:
 */
public class KindleFeatures {
  public static void main(String[] args) {
    String[] possibleFeatures = {"storage", "battery", "hover", "alexa", "waterproof", "solar"};
    int topFeatures = 2;
    String[] featureRequests = {
      "I wish my Kindle had even more storage",
      "I wish the battery life on my Kindle lasted 2 years",
      "I read in the bath and would enjoy a waterproof Kindle",
      "I want to take my Kindle into the hover battery. Waterproof please waterproof!",
      "It would be neat if my Kindle would hover waterproof on my desk when not in use",
      "How cool would it be if my Kindle charged in the sun via solar power?"
    };

    List<String> features = solve(topFeatures, possibleFeatures, featureRequests);

    for (String feature : features) {
      System.out.print(feature + " ");
    }
  }

  private static List<String> solve(
      int topFeatures, String[] possibleFeatures, String[] featureRequests) {

    if (topFeatures <= 0 || possibleFeatures.length == 0 || featureRequests.length == 0) {
      return Collections.EMPTY_LIST;
    }

    HashMap<String, Integer> posFeatures = new HashMap<>();
    for (String feature : possibleFeatures) {
      posFeatures.put(feature.toLowerCase(), 0);
    }

    for (String request : featureRequests) {
      String[] keywords = request.toLowerCase().split("[^a-zA-Z]+");
      Arrays.sort(keywords);
      String prevKeyword = "";
      for (String keyword : keywords) {
        if (posFeatures.keySet().contains(keyword) && ! keyword.equals(prevKeyword)) {
          posFeatures.put(keyword, posFeatures.getOrDefault(keyword, 0) + 1);
        }
        prevKeyword = keyword;
      }
    }

    List<String> results;
    if (topFeatures > possibleFeatures.length) {
      results =
          posFeatures.entrySet().stream()
              .filter(entry -> entry.getValue() > 0)
              .map(Entry::getKey)
              .collect(Collectors.toList());
      Collections.sort(results);
    } else {
      results =
          posFeatures.entrySet().stream()
              .sorted(
                  (e1, e2) -> {
                    int v = e2.getValue().compareTo(e1.getValue());
                    if (v != 0) return v;
                    return e1.getKey().compareTo(e2.getKey());
                  })
              .map(Entry::getKey)
              .limit(topFeatures)
              .collect(Collectors.toList());
    }
    return results;
  }
}
