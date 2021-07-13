package explore.binarySearchTree;

import java.util.HashMap;

/**
 * @author Sumit Deo
 * @Date 7/12/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1012/
 */
public class LowestCommonAncestorOfABinarySearchTree {
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
        TreeNode node = solution.lowestCommonAncestor(rootNode, node4, rootNode);
        System.out.println(node);
    }

    private static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode rootNode, TreeNode p, TreeNode q) {
            if (p.val > rootNode.val && q.val > rootNode.val) {
                return lowestCommonAncestor(rootNode.right, p, q);
            }
            else if (p.val < rootNode.val && q.val < rootNode.val) {
                return lowestCommonAncestor(rootNode.left, p, q);
            }
            else {
                return rootNode;
            }
        }
    }
}
