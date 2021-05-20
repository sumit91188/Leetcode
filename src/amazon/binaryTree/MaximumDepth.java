package amazon.binaryTree;

import java.util.List;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/3/21
 * @comment: https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
 */
public class MaximumDepth {
  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(6), new TreeNode(7, new TreeNode(8), null)),
            new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), new TreeNode(0)));

    Solution sol = new Solution();
    int maxDepth = sol.maxDepth(treeNode);

    System.out.println(maxDepth);
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

    public int maxDepth(TreeNode rootNode) {
      if (rootNode == null) {
        return 0;
      }
      int leftDepth = maxDepth(rootNode.left);
      int rightDepth = maxDepth(rootNode.right);

      return Math.max(leftDepth, rightDepth) + 1;
    }
  }
}
