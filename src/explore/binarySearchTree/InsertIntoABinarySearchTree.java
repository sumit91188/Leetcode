package explore.binarySearchTree;

/**
 * @author Sumit Deo
 * @Date 7/6/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1000/
 */
public class InsertIntoABinarySearchTree {
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
        TreeNode node = solution.insertIntoBST(rootNode, 10);
        System.out.println(node);
    }

    private static class Solution {
        public TreeNode insertIntoBST(TreeNode rootNode, int val) {
            /*if (rootNode != null) {
                TreeNode node = new TreeNode(val);
                TreeNode currentNode = rootNode;

                while (currentNode != null) {
                    if (val > currentNode.val) {
                        if (currentNode.right == null) {
                            currentNode.right = node;
                            break;
                        }
                        currentNode = currentNode.right;
                    } else {
                        if (currentNode.left == null) {
                            currentNode.left = node;
                            break;
                        }
                        currentNode = currentNode.left;
                    }
                }
            }
            else {
                rootNode = new TreeNode(val);
            }

            return rootNode;*/

            if (rootNode == null) {
                rootNode = new TreeNode(val);
            }

            if (val > rootNode.val) {
                rootNode.right = insertIntoBST(rootNode.right, val);
            }
            else {
                rootNode.left = insertIntoBST(rootNode.left, val);
            }

            return rootNode;
        }
    }
}
