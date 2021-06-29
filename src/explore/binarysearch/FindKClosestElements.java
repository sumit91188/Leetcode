package explore.binarysearch;

import java.util.*;

/**
 * @author Sumit Deo
 * @Date 6/25/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945/
 */
public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,1,10,10,10};
        int k = 1;
        int x = 9;

        Solution solution = new Solution();
        List<Integer> closestElems = solution.findClosestElements(arr, k, x);

        for (int i: closestElems) {
            System.out.print(i + " ");
        }
    }

    private static class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> result = new ArrayList<Integer>();

            // Base case
            if (arr.length == k) {
                for (int i = 0; i < k; i++) {
                    result.add(arr[i]);
                }

                return result;
            }

            // Binary search to find the closest element
            int left = 0;
            int right = arr.length - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (arr[mid] > x) {
                    right = mid - 1;
                } else if (arr[mid] < x) {
                    left = mid + 1;
                } else {
                    break;
                }
            }

            // Initialize our sliding window's bounds
            left = Math.max(0, mid - 1);
            right = left + 1;

            // While the window size is less than k
            while (right - left - 1 < k) {
                // Be careful to not go out of bounds
                if (left == -1) {
                    right += 1;
                    continue;
                }

                // Expand the window towards the side with the closer number
                // Be careful to not go out of bounds with the pointers
                if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    left -= 1;
                } else {
                    right += 1;
                }
            }

            // Build and return the window
            for (int i = left + 1; i < right; i++) {
                result.add(arr[i]);
            }

            return result;
        }
    }
}
