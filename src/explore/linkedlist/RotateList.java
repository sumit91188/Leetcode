package explore.linkedlist;


/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/11/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/
 */
public class RotateList {

  public static void main(String[] args) {
    ListNode node0 = new ListNode(1);
    ListNode node1 = new ListNode(2);
    ListNode node2 = new ListNode(3);

    node0.next = node1;
    node1.next = node2;

    Solution solution = new Solution();
    ListNode node = solution.rotateRight(node0, 5);

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

    public ListNode rotateRight(ListNode headNode, int k) {
      if (headNode == null) {
        return headNode;
      }

      if(headNode.next == null) {
        return headNode;
      }

      int len = 1;
      ListNode tailNode = headNode;
      while (tailNode.next != null) {
        len++;
        tailNode = tailNode.next;
      }

      tailNode.next = headNode;

      ListNode newHeadNode = headNode;
      ListNode newTailNode = tailNode;

      for (int i = 0; i <= len - (k % len) - 1; i++) {
        newHeadNode = newHeadNode.next;
        newTailNode = newTailNode.next;
      }

      newTailNode.next = null;

      return newHeadNode;
    }
  }
}
