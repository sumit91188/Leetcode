package explore.binarytree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/3/21
 * @comment:
 *     https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 */
public class SymmetricTree {
  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3)));

    Solution sol = new Solution();
    boolean isSymmetric = sol.isSymmetric(treeNode);

    System.out.println(isSymmetric);
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

    public boolean isSymmetric(TreeNode rootNode) {
      /*return isMirror(rootNode, rootNode);*/
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(rootNode);
      queue.add(rootNode);

      while (! queue.isEmpty()) {
        TreeNode node1 = queue.poll();
        TreeNode node2 = queue.poll();

        if (node1 == null && node2 == null) continue;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;

        queue.add(node1.left);
        queue.add(node2.right);
        queue.add(node1.right);
        queue.add(node2.left);
      }
      return true;
    }

    /*private boolean isMirror(TreeNode node1, TreeNode node2) {
      if (node1 == null && node2 == null) {
        return true;
      }

      if (node1 == null || node2 == null) {
        return false;
      }

      return (node1.val == node2.val)
          && isMirror(node1.left, node2.right)
          && isMirror(node1.right, node2.left);
    }*/
  }
}
