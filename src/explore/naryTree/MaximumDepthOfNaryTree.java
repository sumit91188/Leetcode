package explore.naryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sumit Deo
 * @Date 7/4/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/n-ary-tree/131/recursion/919/
 */
public class MaximumDepthOfNaryTree {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(5, null));
        nodes.add(new Node(6, null));

        List<Node> nodes1 = new ArrayList<>();
        nodes1.add(new Node(3, nodes));
        nodes1.add(new Node(2, null));
        nodes1.add(new Node(4, null));

        Node root = new Node(1, nodes1);

        Solution solution = new Solution();
        int maxDepth = solution.maxDepth(root);
        System.out.println(maxDepth);
    }

    private static class Solution {
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            List<Integer> heights;
            List<Node> children = root.children;
            if (children == null || children.isEmpty()) {
                return 1;
            }
            else {
                heights = new ArrayList<>();
                for (Node node : children) {
                    heights.add(maxDepth(node));
                }
            }

            return Collections.max(heights) + 1;
        }
    }
}
