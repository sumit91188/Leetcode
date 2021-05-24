package explore.recursion2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sumit Deo
 * @Date 5/23/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2894/
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode treeNode1 =
                new TreeNode(
                        5,
                        new TreeNode(4, new TreeNode(6), new TreeNode(7, new TreeNode(8), null)),
                        new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), new TreeNode(0)));

        TreeNode treeNode2 =
                new TreeNode(
                        5,
                        new TreeNode(4, new TreeNode(6), new TreeNode(7, new TreeNode(8), null)),
                        new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), new TreeNode(0)));

        Solution solution = new Solution();
        System.out.println(solution.isSameTree(treeNode1, treeNode2));
    }

    private static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            /*if (p == null && q == null) return true;
            if (p == null || q == null) return false;

            if (p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);*/
            if (! isSameNode(p, q)) {
                return false;
            }

            Queue<TreeNode> pQueue = new LinkedList<>();
            Queue<TreeNode> qQueue = new LinkedList<>();

            pQueue.offer(p);
            qQueue.offer(q);

            while (! pQueue.isEmpty() || ! qQueue.isEmpty()) {
                TreeNode pNode = pQueue.poll();
                TreeNode qNode = qQueue.poll();

                if (isSameNode(pNode, qNode)) {
                    if (pNode != null) {
                        pQueue.offer(pNode.left);
                        pQueue.offer(pNode.right);
                    }

                    if (qNode != null) {
                        qQueue.offer(qNode.left);
                        qQueue.offer(qNode.right);
                    }
                }
                else {
                    return false;
                }
            }

            return true;
        }

        private boolean isSameNode(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;

            if (p.val != q.val) return false;
            return true;
        }
    }
}
