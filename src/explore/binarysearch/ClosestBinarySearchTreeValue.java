package explore.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sumit Deo
 * @Date 6/27/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/closest-binary-search-tree-value/
 */
public class ClosestBinarySearchTreeValue {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));

        Solution solution = new Solution();
        System.out.println(solution.closestValue(rootNode, 4.7135));
    }


    private static class Solution {
        public int closestValue(TreeNode rootNode, double target) {
            int closestElem = rootNode.val;

            while (rootNode != null) {
                closestElem = Math.abs(rootNode.val - target) < Math.abs(closestElem - target) ? rootNode.val : closestElem;
                rootNode = target > rootNode.val ? rootNode.right : rootNode.left;
            }
            return closestElem;
        }
        /*public int closestValue(TreeNode rootNode, double target) {
            List<Integer> nums = new ArrayList<>();
            inOrderTraversal(rootNode, nums);
            return Collections.min(nums, (o1, o2) -> Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1);
        }

        private void inOrderTraversal(TreeNode rootNode, List<Integer> nums) {
            if (rootNode.left != null) {
                inOrderTraversal(rootNode.left, nums);
            }

            nums.add(rootNode.val);

            if (rootNode.right != null) {
                inOrderTraversal(rootNode.right, nums);
            }
        }*/
    }
}
