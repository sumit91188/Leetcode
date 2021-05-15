package explore.recursion1;

import java.util.List;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.recursion1
 * @date 5/12/21
 * @comment: https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3233/
 */
public class SearchInBST {

  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(
            8,
            new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
            new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

    Solution sol = new Solution();
    TreeNode node = sol.searchBST(treeNode, 6);
    System.out.println(node);
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

    public TreeNode searchBST(TreeNode treeNode, int val) {
      if (treeNode == null) {
        return null;
      }

      if (treeNode.val == val) {
        return treeNode;
      }
      else if (treeNode.val > val) {
        return searchBST(treeNode.left, val);
      }
      else {
        return searchBST(treeNode.right, val);
      }
    }
  }
}
