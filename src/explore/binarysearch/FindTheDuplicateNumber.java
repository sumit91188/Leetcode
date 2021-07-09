package explore.binarysearch;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sumit Deo
 * @Date 7/3/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1039/
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,4,2,2};
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(nums));
    }

    private static class Solution {
        public int findDuplicate(int[] nums) {
            /*Set<Integer> numSet = new HashSet<>();

            for (int num: nums) {
                if (numSet.contains(num)) {
                    return num;
                }
                numSet.add(num);
            }
            return -1;*/

            int tortoise = nums[0];
            int hare = nums[0];

            do {
                tortoise = nums[tortoise];
                hare = nums[nums[hare]];
            }
            while (tortoise != hare);

            tortoise = nums[0];

            while (tortoise != hare) {
                tortoise = nums[tortoise];
                hare = nums[hare];
            }

            return hare;
        }
    }
}
