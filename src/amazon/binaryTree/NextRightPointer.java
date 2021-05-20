package amazon.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/4/21
 * @comment: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/
 */
public class NextRightPointer {
  public static void main(String[] args) {
    Node node = new Node(1,
        new Node(2, new Node(4), new Node(5), null),
        new Node(3, new Node(6), new Node(7), null),
        null);

    Solution solution = new Solution();
    Node connectedNode = solution.connect(node);
    System.out.println(connectedNode);
  }

  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  private static class Solution {

    public Node connect(Node node) {
      Node connectedNode = node;
      if (connectedNode != null) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (! queue.isEmpty()) {
          int levelSize = queue.size();

          for (int i = 0; i <= levelSize - 1; i++) {
            Node currentNode = queue.poll();

            if (i < levelSize - 1) {
              Node nextNode = queue.peek();
              currentNode.next = nextNode;
            }

            if (currentNode.left != null) {
              queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
              queue.offer(currentNode.right);
            }
          }
        }
      }
      return connectedNode;
    }
  }
}
