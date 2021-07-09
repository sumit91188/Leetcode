package explore.binarysearch;

import java.util.HashMap;

/**
 * @author Sumit Deo
 * @Date 7/2/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1035/
 */
public class TwoSumInputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int target = 13;

        Solution solution = new Solution();
        int[] result = solution.twoSum(numbers, target);

        for (int i: result) {
            System.out.print(i + " ");
        }
    }

    private static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            /*HashMap<Integer, Integer> numMap = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                numMap.put(numbers[i], i);
            }

            for (int i = 0; i < numbers.length; i++) {
                if (numMap.containsKey(target - numbers[i]) && i != numMap.get(target - numbers[i])) {
                    return new int[] {i + 1, numMap.get(target - numbers[i]) + 1};
                }
            }
            return new int[] {-1, -1};*/

            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[left] + numbers[right];

                if (sum < target) {
                    left++;
                }
                else if (sum > target) {
                    right--;
                }
                else {
                    return new int[] {left + 1, right + 1};
                }
            }

            return new int[] {-1, -1};
        }
    }
}
