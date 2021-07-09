package explore.naryTree;

import java.util.*;

/**
 * @author Sumit Deo
 * @Date 7/3/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/915/
 */
public class LevelorderTraversal {
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
        List<List<Integer>> elementsList = solution.levelOrder(rootNode);

        for (List<Integer> elements : elementsList) {
            for (int element : elements) {
                System.out.print(element +  " ");
            }
            System.out.println();
        }
    }

    private static class Solution {
        public List<List<Integer>> levelOrder(Node rootNode) {
            /*List<List<Integer>> elementsList = new ArrayList<>();
            if (rootNode != null) {
                Queue<Node> queue = new LinkedList<>();
                int level = 0;
                queue.offer(rootNode);

                while (! queue.isEmpty()) {
                    elementsList.add(new ArrayList<>());
                    int levelSize = queue.size();

                    for (int i = 0; i < levelSize; i++) {
                        Node node = queue.poll();
                        elementsList.get(level).add(node.val);

                        List<Node> children = node.children;

                        if (children != null) {
                            for (Node child : children) {
                                queue.offer(child);
                            }
                        }
                    }
                    level++;
                }
            }
            return elementsList;*/

            List<List<Integer>> elementsList = new ArrayList<>();

            if (rootNode != null) {
                levelOrder(rootNode, elementsList, 0);
            }

            return elementsList;
        }

        private void levelOrder(Node node, List<List<Integer>> elementsList, int level) {
            if (node == null) {
                return;
            }

            if (elementsList.size() <= level) {
                elementsList.add(new ArrayList<>());
            }

            elementsList.get(level).add(node.val);

            List<Node> children = node.children;

            if (children != null) {
                for (Node child : children) {
                    levelOrder(child, elementsList, level + 1);
                }
            }
        }
    }
}
