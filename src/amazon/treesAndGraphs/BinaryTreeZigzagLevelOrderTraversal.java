package amazon.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Sumit Deo
 * @Date 5/20/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2980/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(5, new TreeNode(6), new TreeNode(7)));

        Solution solution = new Solution();
        List<List<Integer>> nodesLists = solution.zigzagLevelOrder(treeNode);

        for (List<Integer> nodeList : nodesLists) {
            for (int node : nodeList) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    private static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode treeNode) {
            List<List<Integer>> nodeList = new ArrayList<>();
            if (treeNode != null) {
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(treeNode);
                int level = 0;

                while (! queue.isEmpty()) {
                    nodeList.add(new ArrayList<>());
                    int levelSize = queue.size();

                    for (int i = 0; i <= levelSize - 1; i++) {
                        TreeNode node = queue.poll();
                        nodeList.get(level).add(node.val);

                        if (level % 2 == 0) {
                            if (node.right != null) {
                                queue.offer(node.right);
                            }

                            if (node.left != null) {
                                queue.offer(node.left);
                            }
                        }
                        else {
                            if (node.left != null) {
                                queue.offer(node.left);
                            }

                            if (node.right != null) {
                                queue.offer(node.right);
                            }
                        }

                    }
                    level++;
                }
            }
            return nodeList;
        }
    }
}
