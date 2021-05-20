package amazon.linkedList;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.linkedList
 * @date 5/1/21
 * @comment: https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
  public static void main(String[] args) {
    ListNode l11 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
    ListNode l21 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
    System.out.println(addTwoNumbers(l11, l21));

    /*int[] l12 = new int[] {0};
    int[] l22 = new int[] {0};
    System.out.println(addTwoNumbers(l12, l22));

    int[] l13 = new int[] {9, 9, 9, 9, 9, 9, 9};
    int[] l23 = new int[] {9, 9, 9, 9};
    System.out.println(addTwoNumbers(l13, l23));

    int[] l14 = new int[] {};
    int[] l24 = new int[] {0, 1};
    System.out.println(addTwoNumbers(l14, l24));

    int[] l15 = new int[] {9, 9};
    int[] l25 = new int[] {1};
    System.out.println(addTwoNumbers(l15, l25));*/
  }

  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode();
    ListNode currentNode = dummyHead;
    int carry = 0;
    ListNode p1 = l1;
    ListNode p2 = l2;
    int x;
    int y;

    while (p1 != null || p2 != null || carry != 0) {
      x = p1 != null ? p1.val : 0;
      y = p2 != null ? p2.val : 0;
      int sum = x + y + carry;
      carry = sum / 10;
      currentNode.next = new ListNode(sum % 10);
      currentNode = currentNode.next;
      p1 = p1 != null ? p1.next : null;
      p2 = p2 != null ? p2.next : null;
    }
    return dummyHead.next;
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
