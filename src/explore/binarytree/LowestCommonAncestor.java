package explore.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/4/21
 * @comment: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/932/
 */
public class LowestCommonAncestor {
  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(3);
    TreeNode node2 = new TreeNode(1);
    TreeNode node3 = new TreeNode(8);
    TreeNode node4 = new TreeNode(9);
    TreeNode node5 = new TreeNode(7);
    TreeNode node6 = new TreeNode(5);
    TreeNode node7 = new TreeNode(4);
    TreeNode node8 = new TreeNode(2);
    TreeNode node9 = new TreeNode(0);

    node1.left = node2;
    node1.right = node3;

    node2.left = node4;
    node2.right = node5;

    node3.left = node6;
    node3.right = node7;

    node4.left = node8;
    node8.right = node9;

    Solution solution = new Solution();
    TreeNode lowestCommonAncestor = solution.lowestCommonAncestor(node1, node8, node2);
    System.out.println(lowestCommonAncestor.val);
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

    public TreeNode lowestCommonAncestor(TreeNode rootNode, TreeNode node1, TreeNode node2) {
      if (node1 == rootNode || node2 == rootNode) {
        return rootNode;
      }

      Stack<TreeNode> stack = new Stack<>();
      HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
      parentMap.put(rootNode, null);
      stack.push(rootNode);
      while (!stack.isEmpty()) {
        TreeNode node = stack.pop();

        if (node.left != null) {
          parentMap.put(node.left, node);
          stack.push(node.left);
        }

        if (node.right != null) {
          parentMap.put(node.right, node);
          stack.push(node.right);
        }
      }

      HashSet<TreeNode> hashSet = new HashSet<>();
      while (node1 != null) {
        hashSet.add(node1);
        node1 = parentMap.get(node1);
      }

      while (! hashSet.contains(node2)) {
        node2 = parentMap.get(node2);
      }

      return node2;
    }
  }
}
