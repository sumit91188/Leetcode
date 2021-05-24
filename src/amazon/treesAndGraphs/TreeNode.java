package amazon.treesAndGraphs;

/**
 * @author Sumit Deo
 * @Date 5/20/21
 * @Project Leetcode
 * @Comments ref class
 */
public class TreeNode {
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
