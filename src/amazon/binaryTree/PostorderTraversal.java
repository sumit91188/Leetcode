package amazon.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/3/21
 * @comment: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/
 */
public class PostorderTraversal {
  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(6), new TreeNode(7, new TreeNode(8), null)),
            new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), new TreeNode(0)));

    Solution sol = new Solution();
    List<Integer> nodes = sol.postorderTraversal(treeNode);

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

    public List<Integer> postorderTraversal(TreeNode rootNode) {
      /*List<Integer> nodes = new ArrayList<>();
      if (rootNode != null) {
        helper(rootNode, nodes);
      }
      return nodes;
      //6 8 7 4 3 1 0 2 5*/

      List<Integer> nodes = new ArrayList<>();
      if (rootNode != null) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(rootNode);

        while (! stack1.isEmpty()) {
          TreeNode node = stack1.pop();
          if (node != null) {
            stack2.push(node);
            if (node.left != null) {
              stack1.push(node.left);
            }

            if (node.right != null) {
              stack1.push(node.right);
            }
          }
        }
        while (! stack2.isEmpty()) {
          nodes.add(stack2.pop().val);
        }
      }
      return nodes;
    }

    private void helper(TreeNode rootNode, List<Integer> nodes) {
      if (rootNode.left != null) {
        helper(rootNode.left, nodes);
      }

      if (rootNode.right != null) {
        helper(rootNode.right, nodes);
      }

      nodes.add(rootNode.val);
    }
  }
}
