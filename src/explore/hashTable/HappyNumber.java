package explore.hashTable;

import java.util.HashSet;

/**
 * @author Sumit Deo
 * @Date 7/17/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1131/
 */
public class HappyNumber {
    public static void main(String[] args) {
        int num = 2;

        Solution solution = new Solution();
        System.out.println(solution.isHappy(num));
    }

    private static class Solution {
        public boolean isHappy(int num) {
            if (num == 0) {
                return false;
            }
            HashSet<Integer> set = new HashSet<>();
            int newNum;

            while (true) {
                newNum = 0;
                while (num != 0) {
                    newNum += Math.pow(num % 10, 2);
                    num = num / 10;
                }

                if (newNum == 1 || set.contains(newNum)) {
                    break;
                }
                set.add(newNum);
                num = newNum;
            }

            return newNum == 1;
        }
    }
}
