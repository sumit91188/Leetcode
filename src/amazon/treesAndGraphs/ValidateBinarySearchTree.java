package amazon.treesAndGraphs;

import java.util.Stack;

/**
 * @author Sumit Deo
 * @Date 5/20/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/514/
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(3, new TreeNode(2, new TreeNode(0), new TreeNode(1)), new TreeNode(5));
        TreeNode rootNode1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(rootNode1));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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

        public boolean isValidBST(TreeNode rootNode) {
            Stack<TreeNode> stack = new Stack<>();
            Integer prev = null;

            while (! stack.isEmpty() || rootNode != null) {
                while (rootNode != null) {
                    stack.push(rootNode);
                    rootNode = rootNode.left;
                }

                rootNode = stack.pop();
                if (prev != null && prev >= rootNode.val) {
                    return false;
                }

                prev = rootNode.val;
                rootNode = rootNode.right;
            }

            return true;
        }


        /*public boolean isValidBST(TreeNode rootNode) {
            return isValidBST(rootNode, null, null);
        }

        private boolean isValidBST(TreeNode node, Integer min, Integer max) {
            if (node == null) {
                return true;
            }

            if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
                return false;
            }

            return isValidBST(node.right, node.val, max) && isValidBST(node.left, min, node.val);
        }*/


    }
}
