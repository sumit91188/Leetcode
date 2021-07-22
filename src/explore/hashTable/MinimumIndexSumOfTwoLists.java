package explore.hashTable;

import java.util.*;

/**
 * @author Sumit Deo
 * @Date 7/17/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1177/
 */
public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        String[] list1 = new String[] {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = new String[] {"KFC","Shogun","Burger King"};

        Solution solution = new Solution();
        String[] restaurants = solution.findRestaurant(list1, list2);
        for (String restaurant : restaurants) {
            System.out.print(restaurant + " ");
        }
    }

    private static class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            HashMap<String, Integer> listMap1 = new HashMap<>();
            HashMap<String, Integer> listMap2 = new HashMap<>();
            HashMap<String, Integer> resultMap = new HashMap<>();

            for (int i = 0; i < list1.length; i++) {
                listMap1.put(list1[i], i);
            }

            for (int i = 0; i < list2.length; i++) {
                listMap2.put(list2[i], i);
            }

            Set<String> restaurants = listMap1.keySet();

            for (String restaurant : restaurants) {
                if (listMap2.containsKey(restaurant)) {
                    resultMap.put(restaurant, listMap1.get(restaurant) + listMap2.get(restaurant));
                }
            }

            int minIndex = Collections.min(resultMap.values());
            Set<String> stringSet = resultMap.keySet();

            List<String> results = new ArrayList<>();
            for (String result : stringSet) {
                if (resultMap.get(result) == minIndex) {
                    results.add(result);
                }
            }


            String[] resultArray = new String[results.size()];
            resultArray = results.toArray(resultArray);
            return resultArray;
        }
    }
}
