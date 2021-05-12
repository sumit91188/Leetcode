package explore.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/10/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208/
 */
public class OddEvenLinkedList {

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
    ListNode node = solution.oddEvenList(node0);

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

    public ListNode oddEvenList(ListNode headNode) {
      Queue<ListNode> evenQueue = new LinkedList<>();
      Queue<ListNode> oddQueue = new LinkedList<>();

      ListNode currentNode = headNode;
      for (int i = 0; currentNode != null; i++, currentNode = currentNode.next) {
        if (i % 2 == 0) {
          evenQueue.offer(currentNode);
        }
        else {
          oddQueue.offer(currentNode);
        }
      }

      ListNode dummyHead = new ListNode(0);
      currentNode = dummyHead;

      while (! evenQueue.isEmpty()) {
        ListNode node = evenQueue.poll();
        currentNode.next = node;
        currentNode = node;
      }

      while (! oddQueue.isEmpty()) {
        ListNode node = oddQueue.poll();
        currentNode.next = node;
        currentNode = node;
      }
      currentNode.next = null;
      return dummyHead.next;
    }
  }
}
