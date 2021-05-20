package amazon.linkedList;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.linkedList
 * @date 5/2/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/77/linked-list/512/
 */
public class MergeKSortedList {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(-10, new ListNode(-9, new ListNode(-9, new ListNode(-3, new ListNode(-1, new ListNode(-1, new ListNode(0)))))));
    ListNode l2 = new ListNode(-5);
    ListNode l3 = new ListNode(4);
    ListNode l4 = new ListNode(-8);
    ListNode l5 = null;
    ListNode l6 = new ListNode(-9, new ListNode(-6, new ListNode(-5, new ListNode(-4, new ListNode(-2, new ListNode(2, new ListNode(3)))))));
    ListNode l7 = new ListNode(-3, new ListNode(-3, new ListNode(-2, new ListNode(-1, new ListNode(0)))));

    ListNode node = mergeKLists(new ListNode[] {l1,l2,l3,l4,l5,l6,l7});
    System.out.println(node);
  }

  private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    else if (l2 == null) {
      return l1;
    }
    else {
      if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
      }
      else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
      }
    }
  }
  
  private static ListNode mergeKLists(ListNode[] listNodes) {
    if (listNodes.length == 0) {
      return null;
    }
    else if (listNodes.length == 1) {
      return listNodes[0];
    }
    else {
      /*ListNode node = listNodes[0];
      for (int i = 1; i <= listNodes.length - 1; i++) {
        node = mergeTwoLists(node, listNodes[i]);
      }
      return node;*/
      int size = listNodes.length;
      int count = 1;
      while (count < size) {
        for (int i = 0; i< size - count; i += count * 2) {
          listNodes[i] = mergeTwoLists(listNodes[i], listNodes[i + count]);
        }
        count *= 2;
      }
      return listNodes[0];
    }
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
