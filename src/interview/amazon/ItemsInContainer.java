package interview.amazon;

import java.util.*;

/**
 * @author Sumit Deo
 * @Date 5/25/21
 * @Project Leetcode
 * @Comments https://leetcode.com/discuss/interview-question/1148760/items-in-containers-amazon-oa
 */
public class ItemsInContainer {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> startIndices = Arrays.asList(1, 1);
        List<Integer> endIndices = Arrays.asList(5, 6);
        List<Integer> items = solution.numberOfItems("|**|*|*", startIndices, endIndices);
    }


    private static class Solution {
        public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
            int n = s.length();
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int cumSum = 0;
            boolean started = false;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '|') {
                    if (started) {
                        cumSum += sum;
                        map.put(i, cumSum);
                    } else
                        map.put(i, 0);
                    started = true;
                    sum = 0;
                } else {
                    sum++;
                }
            }
            // map: 0:0, 3:2, 5:3
            int right = -1;
            int[] rightBoundary = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == '|') {
                    right = i;
                }
                rightBoundary[i] = right;
            }
            // [0, 3, 3, 3, 5, 5, -1]
            // right = 0
            int left = -1;
            int[] leftBoundary = new int[n];
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '|') {
                    left = i;
                }
                leftBoundary[i] = left;
            }
            List<Integer> res = new ArrayList<>();

            // [0, 0, 0, 3, 3, 5, 5]
            for (int i = 0; i < startIndices.size(); i++) {
                int start = rightBoundary[startIndices.get(i) - 1]; // 0
                int end = leftBoundary[endIndices.get(i) - 1]; //2
                if (start != -1 && right != -1 && start < end) {
                    res.add(map.get(end) - map.get(start));
                } else
                    res.add(0);
            }

            return res;
        }
    }
}
