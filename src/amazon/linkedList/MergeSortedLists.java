package amazon.linkedList;
/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.linkedList
 * @date 5/2/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/77/linked-list/2976/
 */
public class MergeSortedLists {
  public static void main(String[] args) {
    ListNode l11 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(9, new ListNode(11, new ListNode(12))))));
    ListNode l21 = new ListNode(3, new ListNode(4, new ListNode(9, new ListNode(10))));
    System.out.println(mergeTwoLists(l11, l21));

    ListNode l12 = new ListNode();
    ListNode l22 = new ListNode();
    System.out.println(mergeTwoLists(l12, l22));

    ListNode l13 = new ListNode();
    ListNode l23 = new ListNode(0);
    System.out.println(mergeTwoLists(l13, l23));
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
