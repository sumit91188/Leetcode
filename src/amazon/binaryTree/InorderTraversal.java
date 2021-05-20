package amazon.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/3/21
 * @comment: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929/
 */
public class InorderTraversal {
  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(6), new TreeNode(7, new TreeNode(8), null)),
            new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), new TreeNode(0)));

    Solution sol = new Solution();
    List<Integer> nodes = sol.inorderTraversal(treeNode);

    for (int node : nodes) {
      System.out.println(node);
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

    public List<Integer> inorderTraversal(TreeNode rootNode) {
      List<Integer> nodes = new ArrayList<>();
      if (rootNode != null) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(rootNode);
        TreeNode node = rootNode;

        while (!stack.isEmpty()) {
          while (node != null && node.left != null) {
            stack.push(node.left);
            node = node.left;
          }

          TreeNode popNode = stack.pop();

          if (popNode.right != null) {
            stack.push(popNode.right);
            node = popNode.right;
          }

          nodes.add(popNode.val);
        }
      }
      return nodes;
      /*List<Integer> nodes = new ArrayList<>();
      helper(rootNode, nodes);
      return nodes;*/
    }

    private void helper(TreeNode rootNode, List<Integer> nodes) {
      if (rootNode.left != null) {
        helper(rootNode.left, nodes);
      }

      nodes.add(rootNode.val);

      if (rootNode.right != null) {
        helper(rootNode.right, nodes);
      }
    }
  }
}
