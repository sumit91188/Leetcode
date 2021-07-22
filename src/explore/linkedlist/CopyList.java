package explore.linkedlist;

import java.util.HashMap;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.linkedList
 * @date 5/2/21
 * @comment: https://leetcode.com/explore/interview/card/amazon/77/linked-list/2978/
 */
public class CopyList {
  public static void main(String[] args) {
    Node node0 = new Node(7);
    Node node1 = new Node(13);
    Node node2 = new Node(11);
    Node node3 = new Node(10);
    Node node4 = new Node(1);

    node0.next = node1;

    node1.next = node2;
    node1.random = node0;

    node2.next = node3;
    node2.random = node4;

    node3.next = node4;
    node3.random = node2;

    node4.random = node0;

    Solution sol = new Solution();
    Node node = sol.copyRandomList(node0);
    System.out.println(node);
  }

  private static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  private static class Solution {
    HashMap<Node, Node> nodeHashMap = new HashMap<>();
    private Node copyRandomList(Node head) {
      /*if (head == null) {
        return null;
      }

      if(this.nodeHashMap.containsKey(head)) {
        return this.nodeHashMap.get(head);
      }

      Node node = new Node(head.val);
      this.nodeHashMap.put(head, node);

      node.next = this.copyRandomList(head.next);
      node.random = this.copyRandomList(head.random);
      return node;*/

      if (head == null) {
        return null;
      }

      Node originalNode = head;
      Node copiedNode = new Node(originalNode.val);
      nodeHashMap.put(originalNode, copiedNode);

      while (originalNode != null) {
        copiedNode.next = this.getClonedNode(originalNode.next);
        copiedNode.random = this.getClonedNode(originalNode.random);
        originalNode = originalNode.next;
        copiedNode = copiedNode.next;
      }
      return nodeHashMap.get(head);
    }

    private Node getClonedNode(Node node) {
      if (node != null) {
        if (!nodeHashMap.containsKey(node)) {
          nodeHashMap.put(node, new Node(node.val));
        }
        return nodeHashMap.get(node);
      }
      return null;
    }
  }
}
