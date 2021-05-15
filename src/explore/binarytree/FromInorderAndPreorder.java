package explore.binarytree;

import java.util.HashMap;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/4/21
 * @comment:
 */
public class FromInorderAndPreorder {
  public static void main(String[] args) {
    int[] preorder = new int[]{3,9,20,15,7};
    int[] inorder = new int[]{9,3,15,20,7};

    Solution solution = new Solution();
    TreeNode rootNode = solution.buildTree(inorder, preorder);
    System.out.println(rootNode.val);
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

    HashMap<Integer, Integer> indexMap = new HashMap<>();
    int preOrderIndex;
    int[] inOrder;
    int[] preorder;
    public TreeNode buildTree(int[] inorder, int[] preorder) {
      this.inOrder = inorder;
      this.preorder = preorder;
      preOrderIndex = 0;
      int index = 0;
      for (int i : inorder) {
          indexMap.put(i, index++);
      }
      return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int leftInOderIndex, int rightInOrderIndex) {
      if (leftInOderIndex > rightInOrderIndex) {
        return null;
      }

      int rootNodeVal = preorder[preOrderIndex];
      TreeNode rootNode = new TreeNode(rootNodeVal);
      int index = indexMap.get(rootNodeVal);
      preOrderIndex++;

      rootNode.left = helper(leftInOderIndex, index - 1);
      rootNode.right = helper(index + 1, rightInOrderIndex);
      return rootNode;
    }
  }
}
