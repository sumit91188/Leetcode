package explore.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/3/21
 * @comment: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
 */
public class PreOrderTraversal {
  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(6), new TreeNode(7, new TreeNode(8), null)),
            new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), new TreeNode(0)));

    Solution sol = new Solution();
    List<Integer> nodes = sol.preorderTraversal(treeNode);

    for (int node : nodes) {
      System.out.print(node + " ");
    }
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  private static class Solution {
    private static List<Integer> preorderTraversal(TreeNode rootNode) {
      List<Integer> nodes = new ArrayList<>();
      if (rootNode != null) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(rootNode);
        while (! stack.isEmpty()) {
          TreeNode node = stack.pop();

          if (node.right != null) {
            stack.push(node.right);
          }

          if (node.left != null) {
            stack.push(node.left);
          }

          nodes.add(node.val);
        }
      }
      return nodes;
      //5 4 6 7 8 2 1 3 0

      //morris traversal
      /*List<Integer> nodes = new ArrayList<>();
      TreeNode node = rootNode;

      while (node != null) {
        if (node.left == null) {
          nodes.add(node.val);
          node = node.right;
        }
        else {
          TreeNode predecessor = node.left;

          while (predecessor.right != null && predecessor.right != node) {
            predecessor = predecessor.right;
          }

          if (predecessor.right == null) {
            nodes.add(node.val);
            predecessor.right = node;
            node = node.left;
          }
          else {
            predecessor.right = null;
            node = node.right;
          }
        }
      }

      return nodes;*/

      /*List<Integer> nodes = new ArrayList<>();
      helper(rootNode, nodes);
      return nodes;
      //5 4 6 7 8 2 1 3 0*/
    }

    private static void helper(TreeNode rootNode, List<Integer> nodes) {
      nodes.add(rootNode.val);

      if (rootNode.left != null) {
        helper(rootNode.left, nodes);
      }

      if (rootNode.right != null) {
        helper(rootNode.right, nodes);
      }
    }
  }
}
