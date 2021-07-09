package explore.naryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Sumit Deo
 * @Date 7/3/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/1787/
 */
public class PostorderTraversal {
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
        List<Integer> elements = solution.postorder(rootNode);

        for (int element : elements) {
            System.out.print(element + " ");
        }
    }

    private static class Solution {
        public List<Integer> postorder(Node rootNode) {
            /*List<Integer> elements = new ArrayList<>();
            if (rootNode != null) {
                Stack<Node> stack1 = new Stack<>();
                Stack<Node> stack2 = new Stack<>();
                stack1.push(rootNode);

                while (! stack1.empty()) {
                    Node node = stack1.pop();

                    if (node != null) {
                        stack2.push(node);
                        List<Node> children = node.children;

                        if (children != null) {
                            for (Node child : children) {
                                stack1.push(child);
                            }
                        }
                    }
                }

                while (! stack2.empty()) {
                    Node node = stack2.pop();
                    elements.add(node.val);
                }
            }
            return elements;*/

            List<Integer> elements = new ArrayList<>();

            if (rootNode != null) {
                postorder(rootNode, elements);
            }

            return elements;
        }

        private void postorder(Node node, List<Integer> elements) {
            if (node == null) {
                return;
            }

            List<Node> children = node.children;

            if (children != null) {
                for (Node child : children) {
                    postorder(child, elements);
                }
            }

            elements.add(node.val);
        }
    }
}
