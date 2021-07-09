package explore.binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Sumit Deo
 * @Date 7/3/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 */
public class FindKthSmallestPairDistance {
    public static void main(String[] args) {
        int[] nums = new int[]{9,10,7,10,6,1,5,4,9,8};
        int k = 18;

        Solution solution = new Solution();
        System.out.println(solution.smallestDistancePair(nums, k));
    }

    private static class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            PriorityQueue<Node> heap = new PriorityQueue<>(nums.length, Comparator.comparingInt(o -> (o.nextNum - o.num)));
            for (int i = 0; i < nums.length - 1; i++) {
                int sameNumCount = 0;
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    heap.offer(new Node(nums[i], nums[i + 1]));
                    i++;
                    sameNumCount++;
                }

                while (i < nums.length - 1 && sameNumCount > 0) {
                    heap.offer(new Node(nums[i], nums[i + 1]));
                    sameNumCount--;
                }

                if (i < nums.length - 1) {
                    heap.offer(new Node(nums[i], nums[i + 1]));
                }
            }

            Node node = null;
            for (int i = k; i > 0; i--) {
                node = heap.poll();
            }

            return node != null ? node.nextNum - node.num : 0;
        }


        private class Node {
            int num;
            int nextNum;

            public Node(int num, int nextNum) {
                this.num = num;
                this.nextNum = nextNum;
            }
        }
    }
}
