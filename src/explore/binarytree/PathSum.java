package explore.binarytree;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/3/21
 * @comment:
 *     https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
 */
public class PathSum {
  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(
            1,
            new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3)),
            new TreeNode(-3, new TreeNode(-2), null));

    Solution sol = new Solution();
    boolean hasPathSum = sol.hasPathSum(treeNode, 2);

    System.out.println(hasPathSum);
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

    public boolean hasPathSum(TreeNode rootNode, int targetSum) {
      /*if (rootNode != null) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.push(rootNode);
        sumStack.push(targetSum - rootNode.val);
        int currentSum;
        while (!stack.isEmpty()) {
          TreeNode node = stack.pop();
          currentSum = sumStack.pop();
          if (node.left == null && node.right == null && currentSum == 0) {
            return true;
          }

          if (node.right != null) {
            stack.push(node.right);
            sumStack.push(currentSum - node.right.val);
          }

          if (node.left != null) {
            stack.push(node.left);
            sumStack.push(currentSum - node.left.val);
          }
        }
      }
      return false;*/
      if (rootNode == null) return false;

      if (rootNode.left == null && rootNode.right == null) {
        return targetSum - rootNode.val == 0;
      }
      return hasPathSum(rootNode.left, targetSum - rootNode.val)
          || hasPathSum(rootNode.right, targetSum - rootNode.val);
    }
  }
}
