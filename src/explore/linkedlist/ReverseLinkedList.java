package explore.linkedlist;

import java.util.List;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/10/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1205/
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
      ListNode reversedHeadNode = null;
      ListNode currentNode = headNode;

      while (currentNode != null) {
        ListNode nextNode = currentNode.next;
        currentNode.next = reversedHeadNode;
        reversedHeadNode = currentNode;
        currentNode = nextNode;
      }
      return reversedHeadNode;
    }
  }
}
