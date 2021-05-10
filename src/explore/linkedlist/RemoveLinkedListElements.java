package explore.linkedlist;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/10/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/
 */
public class RemoveLinkedListElements {

  public static void main(String[] args) {
    ListNode node0 = new ListNode(4);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(4);
    ListNode node3 = new ListNode(4);
    ListNode node4 = new ListNode(2);
    ListNode node5 = new ListNode(1);
    ListNode node6 = new ListNode(3);
    ListNode node7 = new ListNode(4);

    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;

    Solution solution = new Solution();
    ListNode node = solution.removeElements(node0, 4);

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

    public ListNode removeElements(ListNode headNode, int val) {
      /*ListNode currentNode = headNode;
      ListNode previousNode = null;
      while (currentNode != null) {
        if (currentNode.val == val) {
          if (previousNode == null) {
            headNode = currentNode.next;
          }
          else {
            previousNode.next = currentNode.next;
          }
        }
        else {
          previousNode = currentNode;
        }
        currentNode = currentNode.next;
      }
      return headNode;*/

      ListNode dummyHead = new ListNode(0);
      dummyHead.next = headNode;
      ListNode currentNode = headNode;
      ListNode previousNode = dummyHead;

      while (currentNode != null) {
        if (currentNode.val == val) {
          previousNode.next = currentNode.next;
        }
        else {
          previousNode = currentNode;
        }
        currentNode = currentNode.next;
      }

      return dummyHead.next;
    }
  }
}
