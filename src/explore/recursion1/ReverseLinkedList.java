package explore.recursion1;

import java.util.List;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.recursion1
 * @date 5/12/21
 * @comment: https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/2378/
 */
public class ReverseLinkedList {

  public static void main(String[] args) {
    ListNode node0 = new ListNode(1);
    ListNode node1 = new ListNode(2);
    ListNode node2 = new ListNode(3);
    ListNode node3 = new ListNode(4);
    ListNode node4 = new ListNode(5);

    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    Solution solution = new Solution();
    ListNode node = solution.reverseList(node0);

    while (node != null) {
      System.out.println(node);
      node = node.next;
    }
  }

  private static class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return "Node{" +
          "val=" + val +
          '}';
    }
  }

  private static class Solution {

    public ListNode reverseList(ListNode headNode) {
      if (headNode == null || headNode.next == null) {
        return headNode;
      }

      ListNode reversedHeadNode = reverseList(headNode.next);
      headNode.next.next = headNode;
      headNode.next = null;
      return reversedHeadNode;
    }
  }
}
