package explore.binarySearchTree;

import java.util.Stack;

/**
 * @author Sumit Deo
 * @Date 6/20/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/998/
 */
public class InorderSuccessorInBST {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);

        rootNode.left = node1;
        rootNode.right = node2;

        node1.left = node3;
        node1.right = node4;

        node3.left = node5;

        Solution solution = new Solution();
        System.out.println(solution.inorderSuccessor(rootNode, node4));
    }

    private static class Solution {
        public TreeNode inorderSuccessor(TreeNode rootNode, TreeNode node) {
            TreeNode successor = null;

            while (rootNode != null) {
                if (node.val >= rootNode.val) {
                    rootNode = rootNode.right;
                }
                else {
                    successor = rootNode;
                    rootNode = rootNode.left;
                }
            }

            return successor;
        }
    }
}
