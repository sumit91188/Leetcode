package explore.linkedlist;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/8/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1212/
 */
public class LinkedListCycle {

  public static void main(String[] args) {
    Node node0 = new Node(3);
    Node node1 = new Node(2);
    Node node2 = new Node(0);
    Node node3 = new Node(-4);

    node0.nextNode = node1;
    node1.nextNode = node2;
    node2.nextNode = node3;
    node3.nextNode = node1;

    Solution solution = new Solution();
    boolean hasCycle = solution.hasCycle(node0);
    System.out.println(hasCycle);
  }

  private static class Solution {

    public boolean hasCycle(Node headNode) {
      if (headNode == null) {
        return false;
      }

      Node tortoiseNode = headNode;
      Node hareNode = headNode;

      while (hareNode != null && hareNode.nextNode != null) {
        tortoiseNode = tortoiseNode.nextNode;
        hareNode = hareNode.nextNode.nextNode;

        if (tortoiseNode == hareNode) {
          return true;
        }
      }
      return false;
    }
  }

  private static class Node {

    int val;
    Node nextNode;

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, Node nextNode) {
      this.val = val;
      this.nextNode = nextNode;
    }

    @Override
    public String toString() {
      return "Node{" +
          "val=" + val +
          '}';
    }
  }
}
