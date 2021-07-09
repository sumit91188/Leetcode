package explore.binarySearchTree;

/**
 * @author Sumit Deo
 * @Date 7/7/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1006/
 */
public class DeleteNodeInABST {
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
        TreeNode node = solution.deleteNode(rootNode, 2);
        System.out.println(node);
    }

    private static class Solution {
        public TreeNode deleteNode(TreeNode rootNode, int key) {
            if (rootNode == null) {
                return null;
            }

            if (key > rootNode.val) {
                rootNode.right = deleteNode(rootNode.right, key);
            }
            else if (key < rootNode.val) {
                rootNode.left = deleteNode(rootNode.left, key);
            }
            else {
                if (rootNode.left == null && rootNode.right == null) {
                    rootNode = null;
                }
                else if (rootNode.right != null) {
                    rootNode.val = successor(rootNode);
                    rootNode.right = deleteNode(rootNode.right, rootNode.val);
                }
                else {
                    rootNode.val = predecessor(rootNode);
                    rootNode.left = deleteNode(rootNode.left, rootNode.val);
                }
            }
            return rootNode;
        }

        private int predecessor(TreeNode rootNode) {
            rootNode = rootNode.left;
            while (rootNode.right != null) {
                rootNode = rootNode.right;
            }
            return rootNode.val;
        }

        private int successor(TreeNode rootNode) {
            rootNode = rootNode.right;
            while (rootNode.left != null) {
                rootNode = rootNode.left;
            }
            return rootNode.val;
        }
    }
}
