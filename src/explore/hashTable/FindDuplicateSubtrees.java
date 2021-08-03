package explore.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Sumit Deo
 * @Date 7/27/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1127/
 */
public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(
                        2,
                        new TreeNode(1, new TreeNode(11), null),
                        new TreeNode(11, new TreeNode(1), null));

        Solution sol = new Solution();
        List<TreeNode> nodes = sol.findDuplicateSubtrees(treeNode);
        System.out.println(nodes);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode treeNode) {
            if (treeNode == null) {
                return new ArrayList<>();
            }

            HashMap<String, Integer> map = new HashMap<>();
            List<TreeNode> duplicates = new ArrayList<>();

            inOrderTraversal(treeNode, map, duplicates, "");
            return duplicates;
        }

        private String inOrderTraversal(TreeNode treeNode, HashMap<String, Integer> map, List<TreeNode> duplicates, String key) {
            if (treeNode == null) {
                return key + "#";
            }

            String left = inOrderTraversal(treeNode.left, map, duplicates, key);
            String right = inOrderTraversal(treeNode.right, map, duplicates, key);

            key += "#" + treeNode.val + left + right;

            map.put(key, map.getOrDefault(key, 0) + 1);
            if (map.get(key) == 2) {
                duplicates.add(treeNode);
            }

            return key;
        }
    }
}
