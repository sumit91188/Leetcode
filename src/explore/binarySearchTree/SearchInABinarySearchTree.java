package explore.binarySearchTree;

/**
 * @author Sumit Deo
 * @Date 7/6/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1000/
 */
public class SearchInABinarySearchTree {
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
        TreeNode node = solution.searchBST(rootNode, 2);
        System.out.println(node);
    }

    private static class Solution {
        public TreeNode searchBST(TreeNode rootNode, int target) {
            /*TreeNode node = null;

            if (rootNode != null) {
                TreeNode currentNode = rootNode;

                while (currentNode != null) {
                    if (currentNode.val == target) {
                        node = currentNode;
                        break;
                    }
                    else if (target > currentNode.val) {
                        currentNode = currentNode.right;
                    }
                    else {
                        currentNode = currentNode.left;
                    }
                }
            }

            return node;*/

            if (rootNode == null) {
                return null;
            }

            if (rootNode.val == target) {
                return rootNode;
            }

            return target > rootNode.val ? searchBST(rootNode.right, target) : searchBST(rootNode.left, target);
        }
    }
}
