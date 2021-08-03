package explore.hashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Sumit Deo
 * @Date 7/27/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1179/
 */
public class TwoSumIIIDataStructureDesign {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);

        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(7));
    }

    private static class TwoSum {
        HashMap<Integer, Integer> map;

        /** Initialize your data structure here. */
        public TwoSum() {
            map = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

            for (Map.Entry<Integer, Integer> entry : entries) {
                int complement = value - entry.getKey();

                if (complement == entry.getKey()) {
                    if (entry.getValue() >= 2) {
                        return true;
                    }
                }
                else {
                    if (map.containsKey(complement)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
