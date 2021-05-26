package amazon.linkedList;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.linkedList
 * @date 5/2/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/77/linked-list/2977/
 */
public class ReverseKGroup {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode result = reverseKGroup(l1, 2);
    System.out.println(result);
    /*System.out.println(reverseKGroup(l1, 3));
    System.out.println(reverseKGroup(l1, 1));*/
  }

  private static ListNode reverseKGroup(ListNode head, int k) {
    int count = 0;
    ListNode currentNode = head;

    while (count < k && currentNode != null) {
      currentNode = currentNode.next;
      count++;
    }

    if (count == k) {
      ListNode reversedHead = reverseLinkedList(head, k);
      head.next = reverseKGroup(currentNode, k);
      return reversedHead;
    }
    return head;
  }

  private static ListNode reverseLinkedList(ListNode head, int k) {
    ListNode reversedHead = null;
    ListNode currentNode = head;

    while (k > 0) {
      ListNode nextNode = currentNode.next;
      currentNode.next = reversedHead;
      reversedHead = currentNode;
      currentNode = nextNode;
      k--;
    }

    return reversedHead;
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
