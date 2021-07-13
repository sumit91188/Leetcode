package explore.binarySearchTree;

/**
 * @author Sumit Deo
 * @Date 7/13/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/143/appendix-height-balanced-bst/1027/
 */
public class BalancedBinaryTree {
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
        boolean isBalanced = solution.isBalanced(rootNode);
        System.out.println(isBalanced);
    }

    private static class Solution {
        public boolean isBalanced(TreeNode rootNode) {
            if (rootNode == null) {
                return true;
            }

            return Math.abs(height(rootNode.right) - height(rootNode.left)) <= 1 &&
                    isBalanced(rootNode.left) &&
                    isBalanced(rootNode.right);
        }

        private int height(TreeNode node) {
            if (node == null) {
                return 0;
            }

            return 1 + Math.max(height(node.left), height(node.right));
        }
    }
}
