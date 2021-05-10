package explore.linkedlist;

import java.util.HashMap;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/10/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/
 */
public class RemoveNthNodeFromEndOfList {

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
    ListNode node = solution.removeNthFromEnd(node0, 2);

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

    public ListNode removeNthFromEnd(ListNode headNode, int n) {
      /*HashMap<Integer, ListNode> nodeHashMap = new HashMap<>();

      int index = 0;
      while (headNode != null) {
        nodeHashMap.put(index++, headNode);
        headNode = headNode.next;
      }

      if (n > 0 && n <= nodeHashMap.size()) {
        if (n == nodeHashMap.size()) {
          return nodeHashMap.getOrDefault(1, null);
        }
        else if (n == 1) {
          nodeHashMap.get(nodeHashMap.size() - n - 1).next = null;
          return nodeHashMap.get(0);
        }
        else {
          nodeHashMap.get(nodeHashMap.size() - n - 1).next = nodeHashMap.get(nodeHashMap.size() - n + 1);
          return nodeHashMap.get(0);
        }
      }
      return null;*/

      ListNode dummyHead = new ListNode(0);
      dummyHead.next = headNode;

      ListNode slowNode = dummyHead;
      ListNode fastNode = dummyHead;

      for (int i = 0; i <= n; i++) {
        fastNode = fastNode.next;
      }

      while (fastNode != null) {
        slowNode = slowNode.next;
        fastNode = fastNode.next;
      }

      slowNode.next = slowNode.next.next;
      return dummyHead.next;
    }
  }
}
