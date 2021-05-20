package amazon.binaryTree;

import java.util.List;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/4/21
 * @comment: https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/538/
 */
public class UnivalueSubtree {
  public static void main(String[] args) {
    TreeNode rootNode =
        new TreeNode();

    Solution sol = new Solution();
    int uniValueSubtrees = sol.countUnivalSubtrees(rootNode);

    System.out.println(uniValueSubtrees);
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

    public int countUnivalSubtrees(TreeNode rootNode) {
      return 0;
    }
  }
}
