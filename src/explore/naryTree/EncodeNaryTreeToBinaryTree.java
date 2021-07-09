package explore.naryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Sumit Deo
 * @Date 7/4/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/
 */
public class EncodeNaryTreeToBinaryTree {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(5, null));
        nodes.add(new Node(6, null));

        List<Node> nodes1 = new ArrayList<>();
        nodes1.add(new Node(3, nodes));
        nodes1.add(new Node(2, null));
        nodes1.add(new Node(4, null));

        Node rootNode = new Node(1, nodes1);

        Codec codec = new Codec();
        TreeNode rootTreeNode = codec.encode(rootNode);
        Node node = codec.decode(rootTreeNode);
    }

    private static class Codec {
        public TreeNode encode(Node rootNode) {
            if (rootNode == null) {
                return null;
            }

            TreeNode newRoot = new TreeNode(rootNode.val);
            Pair<TreeNode, Node> head = new Pair(newRoot, rootNode);

            Queue<Pair<TreeNode, Node>> queue = new LinkedList<>();
            queue.add(head);

            while (! queue.isEmpty()) {
                Pair<TreeNode, Node> pair = queue.poll();
                TreeNode bNode = pair.first;
                Node nNode = pair.second;

                TreeNode previousBNode = null;
                TreeNode headBNode = null;

                for (Node nChild : nNode.children) {
                    TreeNode newBNode = new TreeNode(nChild.val);
                    if (previousBNode == null) {
                        headBNode = newBNode;
                    }
                    else {
                        previousBNode.right = newBNode;
                    }
                    previousBNode = newBNode;

                    Pair<TreeNode, Node> nextEntry = new Pair<>(newBNode, nChild);
                    queue.add(nextEntry);
                }

                bNode.left = headBNode;
            }
            return newRoot;
        }

        public Node decode(TreeNode rootTreeNode) {
            return null;
        }

        private class Pair<U, V> {
            public U first;
            public V second;
            public Pair(U first, V second) {
                this.first = first;
                this.second = second;
            }
        }
    }
}
