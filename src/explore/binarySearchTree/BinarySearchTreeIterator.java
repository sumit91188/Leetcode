package explore.binarySearchTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author Sumit Deo
 * @Date 6/20/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/1008/
 */
public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));

        BSTIterator bstIterator = new BSTIterator(rootNode);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }

    private static class BSTIterator {

        TreeNode root;
        ArrayList<TreeNode> treeNodes;
        Iterator<TreeNode> iterator;

        public BSTIterator(TreeNode root) {
            this.root = root;
            treeNodes = new ArrayList<>();

            if (root != null) {
                Stack<TreeNode> stack = new Stack<>();
                stack.push(root);
                TreeNode node = root;

                while (!stack.empty()) {
                    while (node != null && node.left != null) {
                        stack.push(node.left);
                        node = node.left;
                    }

                    TreeNode popNode = stack.pop();

                    if (popNode.right != null) {
                        stack.push(popNode.right);
                        node = popNode.right;
                    }

                    treeNodes.add(popNode);
                }
            }
            iterator = treeNodes.iterator();
        }

        public int next() {
            return iterator.next().val;
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }
    }
}
