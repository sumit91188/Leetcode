package amazon.linkedList;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.linkedList
 * @date 5/2/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/77/linked-list/2979/
 */
public class ReverseList {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode reversedHead = reverseList(l1);
    System.out.println(reversedHead);
  }

  private static ListNode reverseList(ListNode headNode) {
    /*ListNode reversedHeadNode = null;
    ListNode currentNode = headNode;

    while (currentNode != null) {
      ListNode nextNode = currentNode.next;
      currentNode.next = reversedHeadNode;
      reversedHeadNode = currentNode;
      currentNode = nextNode;
    }
    return reversedHeadNode;*/
    if (headNode == null || headNode.next == null) {
      return headNode;
    }
    ListNode p = reverseList(headNode.next);
    headNode.next.next = headNode;
    headNode.next = null;
    return p;
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
