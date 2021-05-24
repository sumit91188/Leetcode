package amazon.treesAndGraphs;

/**
 * @author Sumit Deo
 * @Date 5/20/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2981/
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(
                        -10,
                        new TreeNode(2),
                        new TreeNode(5, new TreeNode(6), new TreeNode(7)));

        Solution solution = new Solution();
        System.out.println(solution.maxPathSum(treeNode));
    }

    private static class Solution {
        int maxSum = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode treeNode) {
            maxGain(treeNode);
            return maxSum;
        }

        private int maxGain(TreeNode treeNode) {
            if (treeNode == null) {
                return 0;
            }

            int leftGain = Math.max(maxGain(treeNode.left), 0);
            int rightGain = Math.max(maxGain(treeNode.right), 0);

            int totalGain = treeNode.val + leftGain + rightGain;

            if (maxSum < totalGain) {
                maxSum = totalGain;
            }

            return treeNode.val + Math.max(leftGain, rightGain);
        }
    }
}
