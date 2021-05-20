package interview.amazon.AmazonFreshPromotion;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.AmazonFreshPromotion
 * @date 10/4/20
 * @comment: https://leetcode.com/discuss/interview-question/762546/#
 */
public class AmazonFreshPromotion {
  public static void main(String[] args) {
    String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
    String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
    String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
    String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
    String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
    String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
    String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
    String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
    String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
    String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
    String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
    String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
    String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
    String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
    System.out.println(prizeWon(codeList1, shoppingCart1));
    System.out.println(prizeWon(codeList2, shoppingCart2));
    System.out.println(prizeWon(codeList3, shoppingCart3));
    System.out.println(prizeWon(codeList4, shoppingCart4));
    System.out.println(prizeWon(codeList5, shoppingCart5));
    System.out.println(prizeWon(codeList6, shoppingCart6));
    System.out.println(prizeWon(codeList7, shoppingCart7));
  }

  private static int prizeWon(String[][] codeList, String[] shoppingCart) {
    if (codeList == null || codeList.length == 0) return 1;
    if (shoppingCart == null || shoppingCart.length == 0) return 0;

    int groupIndex = 0;
    int codeIndex = 0;
    for (int cartIndex = 0; cartIndex < shoppingCart.length; cartIndex++) {
      if (codeList[groupIndex][codeIndex].equals("anything")
          || codeList[groupIndex][codeIndex].equals(shoppingCart[cartIndex])) {
        codeIndex++;
        if (codeIndex == codeList[groupIndex].length) {
          groupIndex++;
          codeIndex = 0;
        }
        if (groupIndex == codeList.length) {
          return 1;
        }
      }
      else {
        codeIndex = codeList[groupIndex][0].equals("anything") ? 1: 0;
      }
    }
    return 0;
  }
}
