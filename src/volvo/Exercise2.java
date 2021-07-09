package volvo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Sumit Deo
 * @Date 6/30/21
 * @Project Leetcode
 * @Comments
 */
public class Exercise2 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution("0011100"));
        System.out.println(solution.solution("000111"));
        String str = "";

        for (int i = 0; i < 400000; i++) {
            str += "1";
        }

        System.out.println(solution.solution(str));
    }

    private static class Solution {
        public int solution(String S) {
            int count = 0;
            S = S.replaceFirst("^0+(?!$)", "");
            char[] chars = S.toCharArray();
            int length = chars.length;

            while (chars[0] != '0') {
                if (chars[length - 1] == '0') {
                    chars = Arrays.copyOf(chars, length - 1);
                    length--;
                    count++;
                    continue;
                }

                chars[length - 1] = '0';
                count++;
            }
            return count;
        }

        private BigInteger binaryToBigDecimal(String str) {

            /*BigInteger bd1 = new BigInteger(String.valueOf(str.charAt(0) == '1' ? 1 : 0));
            for (int i = 1; i < str.length(); i++) {
                bd1 = bd1.multiply(new BigInteger(String.valueOf(2)));
                bd1 = bd1.add(new BigInteger(String.valueOf(str.charAt(i) == '1' ? 1 : 0)));
            }
            return bd1;*/

            str = str.replaceFirst("^0+(?!$)", "");
            int length = str.length();
            BigInteger value = BigInteger.ZERO;

            for (int i = 0; i < length; i++) {
                if (str.charAt(i) == '1') {
                    value = value.add(new BigInteger(String.valueOf((int) Math.pow(Double.parseDouble("2"), Double.parseDouble(length - i - 1 + "")))));
                }
            }

            return value;
        }

        private boolean isEven(BigInteger bigInteger) {
            if (bigInteger.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                return true;
            }
            return false;
        }
    }
}
