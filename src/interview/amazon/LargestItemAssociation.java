package interview.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package interview.amazon
 * @date 5/15/21
 * @comment: In order to improve customer experience, Amazon has developed a system to provide
 * recommendations to the customer regarding the item they can purchase. Based on historical
 * customer purchase information, an item association can be defined as - If an item A is ordered by
 * a customer, then item B is also likely to be ordered by the same customer (e.g. Book 1 is
 * frequently orderered with Book 2). All items that are linked together by an item association can
 * be considered to be in the same group. An item without any association to any other item can be
 * considered to be in its own item association group of size 1.
 * <p>
 * Given a list of item association relationships(i.e. group of items likely to be ordered
 * together), write an algorithm that outputs the largest item association group. If two groups have
 * the same number of items then select the group which contains the item that appears first in
 * lexicographic order.
 * <p>
 * Input The itput to the function/method consists of an argument - itemAssociation, a list
 * containing paris of string representing the items that are ordered together.
 * <p>
 * Output Return a list of strings representing the largest association group sorted
 * lexicographically.
 * <p>
 * Example Input: itemAssociation: [ [Item1, Item2], [Item3, Item4], [Item4, Item5] ]
 * <p>
 * Output: [Item3, Item4, Item5]
 * <p>
 * Explanation: There are two item association groups: group1: [Item1, Item2] group2:
 * [Item3,Item4,Item5] In the available associations, group2 has the largest association. So, the
 * output is [Item3, Item4, Item5].
 * <p>
 * Helper Description in java The following class is used to represent a Pair of strings and is
 * already implemented in the default code (Do not write this definition again in your code):
 * <p>
 * class PairString { String first; String second;
 * <p>
 * PairString(String first, String second) { this.first = first; this.second = second; } } Method
 * Signature to Implement in java Java
 * <p>
 * List<String> LargestItemAssociation(List<PairString> itemAssociation) { }
 */
public class LargestItemAssociation {

  public static void main(String[] args) {
    PairString pairString1 = new PairString("item1", "item2");
    PairString pairString2 = new PairString("item3", "item4");
    PairString pairString3 = new PairString("item4", "item5");
    List<PairString> pairStringList = new ArrayList<>();
    pairStringList.add(pairString1);
    pairStringList.add(pairString2);
    pairStringList.add(pairString3);

    Solution solution = new Solution();
    List<String> strings = solution.largestItemAssociation(pairStringList);

    for (String str : strings
    ) {
      System.out.print(str + " ");
    }
  }

  static class PairString {

    String first;
    String second;

    PairString(String first, String second) {
      this.first = first;
      this.second = second;
    }
  }

  private static class Solution {

    public List<String> largestItemAssociation(List<PairString> pairStringList) {
      List<String> results = new ArrayList<>();

      List<Set<String>> setList = new ArrayList<>();

      for (PairString pair : pairStringList) {

      }

      return null;
    }
  }
}
