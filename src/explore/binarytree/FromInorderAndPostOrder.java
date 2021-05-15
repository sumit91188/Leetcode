package explore.binarytree;

import java.util.HashMap;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/4/21
 * @comment: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/
 */
public class FromInorderAndPostOrder {
  public static void main(String[] args) {
    int[] inorder = new int[]{9,3,15,20,7};
    int[] postorder = new int[]{9,15,7,20,3};
    
    Solution solution = new Solution();
    TreeNode rootNode = solution.buildTree(inorder, postorder);
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
    int postOrderIndex;
    int[] postOrder;
    int[] inOrder;
    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
      this.postOrder = postorder;
      this.inOrder = inorder;
      postOrderIndex = postOrder.length - 1;
      int index = 0;
      for (int i : inorder) {
          indexMap.put(i, index++);
      }
      return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int inOrderLeftIndex, int inOrderRightIndex) {
      if (inOrderLeftIndex > inOrderRightIndex) {
        return null;
      }

      int rootNodeVal = postOrder[postOrderIndex];
      TreeNode rootNode = new TreeNode(rootNodeVal);
      int index = indexMap.get(rootNodeVal);
      postOrderIndex--;
      rootNode.right = helper(index + 1, inOrderRightIndex);
      rootNode.left = helper(inOrderLeftIndex, index - 1);
      return rootNode;
    }
  }
}
