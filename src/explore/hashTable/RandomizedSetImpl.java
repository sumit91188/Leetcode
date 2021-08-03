package explore.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author Sumit Deo
 * @Date 7/27/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSetImpl {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(1));
        System.out.println(set.remove(2));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
        System.out.println(set.remove(1));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
    }

    private static class RandomizedSet {
        HashMap<Integer, Integer> map;
        List<Integer> list;
        Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (! map.containsKey(val)) {
                map.put(val, list.size());
                list.add(list.size(), val);
                return true;
            }
            return false;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int lastEle = list.get(list.size() - 1);
                int index = map.get(val);
                list.set(index, lastEle);
                map.put(lastEle, index);
                map.remove(val);
                list.remove(list.size() - 1);
                return true;
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
