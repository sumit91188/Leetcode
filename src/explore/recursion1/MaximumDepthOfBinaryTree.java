package explore.recursion1;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.recursion1
 * @date 5/13/21
 * @comment: https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2375/
 */
public class MaximumDepthOfBinaryTree {

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

    public int maxDepth(TreeNode treeNode) {
      if (treeNode == null) {
        return 0;
      }

      return Math.max(maxDepth(treeNode.left), maxDepth(treeNode.right)) + 1;
    }
  }
}
