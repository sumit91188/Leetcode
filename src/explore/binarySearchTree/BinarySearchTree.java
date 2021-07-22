package explore.binarySearchTree;

/**
 * @author Sumit Deo
 * @Date 7/13/21
 * @Project Leetcode
 * @Comments ref
 */
public class BinarySearchTree {
    public TreeNode root = null;

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        else {
            if (val > root.val) {
                root = insert(root.right, val);
            }
            else if (val < root.val) {
                root = insert(root.left, val);
            }
        }

        return root;
    }

    public TreeNode findNode (TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        return val < root.val ? findNode(root.left, val) : findNode(root.right, val);
    }

    public TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val > root.val) {
            root.right = delete(root.right, val);
        }
        else if (val < root.val) {
            root.left = delete(root.left, val);
        }
        else {
            if (root.left == null && root.right == null) {
                root = null;
            }
            else if (root.right != null) {
                root.val = successor(root);
                root.right = delete(root.right, root.val);
            }
            else {
                root.val = predecessor(root);
                root.left = delete(root.left, root.val);
            }
        }

        return root;
    }

    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }


}
