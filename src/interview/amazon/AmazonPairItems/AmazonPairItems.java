package interview.amazon.AmazonPairItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.AmazonPairItems
 * @date 10/5/20
 * @comment:
 */
public class AmazonPairItems {
  public static void main(String[] args) {
    PairString pairString1 = new PairString("Item1", "Item2");
    PairString pairString2 = new PairString("Item3", "Item4");
    PairString pairString3 = new PairString("Item4", "Item5");

    List<PairString> pairStrings = new ArrayList<>();
    pairStrings.add(pairString1);
    pairStrings.add(pairString2);
    pairStrings.add(pairString3);

    List<String> items = largestItemAssociation(pairStrings);
    for (String item : items) {
      System.out.print(item + " ");
    }
  }

  private static List<String> largestItemAssociation(List<PairString> pairStrings) {
    HashMap<String, HashSet<String>> associations = new HashMap<>();
    HashSet<String> items;
    for (PairString pairString : pairStrings) {
      if (! associations.containsKey(pairString.first)) {
        items = new HashSet<>();
        items.add(pairString.first);
        items.add(pairString.second);
      }
    }

    return null;
  }

  public static class PairString {
    String first;
    String second;

    public PairString(String first, String second) {
      this.first = first;
      this.second = second;
    }
  }
}
