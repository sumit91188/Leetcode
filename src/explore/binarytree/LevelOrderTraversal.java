package explore.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/3/21
 * @comment: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/
 */
public class LevelOrderTraversal {
  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(6), new TreeNode(7, new TreeNode(8), null)),
            new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), new TreeNode(0)));

    Solution sol = new Solution();
    List<List<Integer>> nodesLists = sol.levelorderTraversal(treeNode);

    for (List<Integer> nodeList : nodesLists) {
      for (int node : nodeList) {
        System.out.print(node + " ");
      }
      System.out.println();
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

    public List<List<Integer>> levelorderTraversal(TreeNode rootNode) {
      List<List<Integer>> nodesList = new ArrayList<>();
      if (rootNode != null) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(rootNode);
        int level = 0;
        while (! queue.isEmpty()) {
          nodesList.add(new ArrayList<>());
          int levelSize = queue.size();
          for (int i = 0; i <= levelSize - 1; i++) {
            TreeNode node = queue.poll();
            nodesList.get(level).add(node.val);
            if (node.left != null) {
              queue.offer(node.left);
            }

            if (node.right != null) {
              queue.offer(node.right);
            }
          }
          level++;
        }
      }
      return nodesList;
    }
  }
}
