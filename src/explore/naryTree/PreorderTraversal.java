package explore.naryTree;

import java.util.*;

/**
 * @author Sumit Deo
 * @Date 7/3/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/1786/
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(5, null));
        nodes.add(new Node(6, null));

        List<Node> nodes1 = new ArrayList<>();
        nodes1.add(new Node(3, nodes));
        nodes1.add(new Node(2, null));
        nodes1.add(new Node(4, null));

        Node rootNode = new Node(1, nodes1);

        Solution solution = new Solution();
        List<Integer> elements = solution.preorder(rootNode);

        for (int element : elements) {
            System.out.print(element + " ");
        }
    }

    private static class Solution {
        public List<Integer> preorder(Node rootNode) {
            /*List<Integer> elements = new ArrayList<>();
            if (rootNode != null) {
                Stack<Node> stack = new Stack<>();
                stack.push(rootNode);

                while (! stack.empty()) {
                    Node node = stack.pop();
                    int element = node.val;
                    List<Node> children = node.children;

                    if (children != null) {
                        Collections.reverse(children);

                        for (Node child : children) {
                            stack.push(child);
                        }
                    }

                    elements.add(element);
                }
            }
            return elements;*/

            List<Integer> elements = new ArrayList<>();

            if (rootNode != null) {
                preorder(rootNode, elements);
            }

            return elements;
        }

        private void preorder(Node node, List<Integer> elements) {
            if (node == null) {
                return;
            }

            elements.add(node.val);

            List<Node> children = node.children;

            if (children != null) {
                for (Node child : children) {
                    preorder(child, elements);
                }
            }
        }
    }
}
