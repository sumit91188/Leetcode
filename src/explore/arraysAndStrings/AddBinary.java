package explore.arraysAndStrings;

import java.math.BigInteger;

/**
 * @author Sumit Deo
 * @Date 7/31/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        Solution solution = new Solution();
        System.out.println(solution.addBinary(a, b));
    }

    private static class Solution {
        public String addBinary(String a, String b) {
            BigInteger valueA = new BigInteger(a, 2);
            BigInteger valueB = new BigInteger(b, 2);
            BigInteger value0 = new BigInteger("0", 2);

            while (valueB.compareTo(value0) != 0) {
                BigInteger valueSum = valueA.xor(valueB);
                BigInteger valueCarry = valueA.and(valueB).shiftLeft(1);

                valueA = valueSum;
                valueB = valueCarry;
            }
            return valueA.toString(2);
        }
    }
}
