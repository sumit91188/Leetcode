package explore.hashTable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Sumit Deo
 * @Date 7/27/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;

        Solution solution = new Solution();
        int[] topFreqNums = solution.topKFrequent(nums, k);

        for (int num : topFreqNums) {
            System.out.print(num + " ");
        }
    }

    private static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));

            for (int key : map.keySet()) {
                queue.offer(key);
                if (queue.size() > k) {
                    queue.poll();
                }
            }

            int[] result = new int[k];

            for (int i = k - 1; i >= 0; i--) {
                result[i] = queue.poll();
            }

            return result;
        }
    }
}
