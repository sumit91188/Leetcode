package explore.binarySearchTree;

/**
 * @author Sumit Deo
 * @Date 6/20/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/997/
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));

        Solution solution = new Solution();
        System.out.println(solution.validateBst(rootNode));
    }

    private static class Solution {
        public boolean validateBst(TreeNode rootNode) {
            return validateBst(rootNode, null, null);
        }

        private boolean validateBst(TreeNode node, Integer min, Integer max) {
            if (node == null) {
                return true;
            }

            if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
                return false;
            }

            return validateBst(node.left, min, node.val) && validateBst(node.right, node.val, max);
        }
    }
}
