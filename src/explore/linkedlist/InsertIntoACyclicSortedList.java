package explore.linkedlist;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/11/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1226/
 */
public class InsertIntoACyclicSortedList {

  public static void main(String[] args) {
    ListNode node0 = new ListNode(3);
    ListNode node1 = new ListNode(3);
    ListNode node2 = new ListNode(5);

    node0.next = node1;
    node1.next = node2;
    node2.next = node0;

    Solution solution = new Solution();
    ListNode node = solution.insert(node0, 0);

    while (node != null) {
      System.out.println(node);
      node = node.next;
    }
  }

  static class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int _val) {
      val = _val;
    }

    public ListNode(int _val, ListNode _next) {
      val = _val;
      next = _next;
    }
  }

  private static class Solution {

    public ListNode insert(ListNode headNode, int val) {

      if (headNode == null) {
        headNode = new ListNode(val);
        headNode.next = headNode;
      }

      ListNode previousNode = headNode;
      ListNode currentNode = headNode.next;
      boolean shouldInsert = false;

      do {
        if (previousNode.val <= val && val <= currentNode.val) {
          shouldInsert = true;
        }
        if (previousNode.val > currentNode.val) {
          if (val >= previousNode.val || val <= currentNode.val) {
            shouldInsert = true;
          }
        }

        if (shouldInsert) {
          previousNode.next = new ListNode(val, currentNode);
          return headNode;
        }

        previousNode = previousNode.next;
        currentNode = currentNode.next;
      }
      while (previousNode != headNode);

      if (currentNode.val == previousNode.val) {
        previousNode.next = new ListNode(val, currentNode);
      }

      return headNode;
    }
  }
}
