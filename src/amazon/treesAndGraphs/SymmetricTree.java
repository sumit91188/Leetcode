package amazon.treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sumit Deo
 * @Date 5/20/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/507/
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(rootNode));
    }

    private static class Solution {
        public boolean isSymmetric(TreeNode rootNode) {
            if (rootNode == null) {
                return true;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(rootNode);
            queue.offer(rootNode);

            while (! queue.isEmpty()) {
                TreeNode leftNode = queue.poll();
                TreeNode rightNode = queue.poll();

                if (leftNode == null && rightNode == null) continue;
                if (leftNode == null || rightNode == null) return false;
                if (leftNode.val != rightNode.val) return false;

                queue.offer(leftNode.right);
                queue.offer(rightNode.left);
                queue.offer(leftNode.left);
                queue.offer(rightNode.right);
            }

            return true;
        }
        /*public boolean isSymmetric(TreeNode rootNode) {
            if (rootNode == null) {
                return true;
            }

            return isMirror(rootNode, rootNode);
        }

        private boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
            if (leftNode == null && rightNode == null) {
                return true;
            }

            if (leftNode == null || rightNode == null) {
                return false;
            }

            return (leftNode.val == rightNode.val) && isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left);
        }*/


    }
}
