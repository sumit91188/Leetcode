package explore.binarySearchTree;

/**
 * @author Sumit Deo
 * @Date 7/13/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solution/
 * Preorder Traversal: Always Choose Left Middle Node as a Root
 */
public class BalancedBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = new int[] {-10, -3, 0, 5, 9};
        Solution solution = new Solution();
        TreeNode node = solution.sortedArrayToBST(nums);
    }

    private static class Solution {
        int[] nums;
        public TreeNode sortedArrayToBST(int[] nums) {
            this.nums = nums;
            return helper(0, nums.length - 1);
        }

        private TreeNode helper(int left, int right) {
            if (left > right) {
                return null;
            }

            int p = (left + right) / 2;
            TreeNode root = new TreeNode(nums[p]);
            root.left = helper(left, p - 1);
            root.right = helper(p + 1, right);
            return root;
        }
    }
}
