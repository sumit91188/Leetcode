package explore.hashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sumit Deo
 * @Date 7/15/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/design-hashmap/solution/
 */
public class HashMapLinkedList {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
    }

    private static class MyHashMap {
        private List<Bucket> buckets;
        private int key_space;

        public MyHashMap() {
            this.key_space = 2069;
            buckets = new ArrayList<>();
            for (int i = 0; i < key_space; i++) {
                buckets.add(new Bucket());
            }
        }

        public void put(int key, int value) {
            int hash_key = key % this.key_space;
            this.buckets.get(hash_key).update(key, value);
        }

        public int get(int key) {
            int hash_key = key % this.key_space;
            return this.buckets.get(hash_key).get(key);
        }

        public void remove(int key) {
            int hash_key = key % this.key_space;
            this.buckets.get(hash_key).remove(key);
        }

        private class Pair<U, V> {
            public U first;
            public V second;

            public Pair(U first, V second) {
                this.first = first;
                this.second = second;
            }
        }

        private class Bucket {
            private List<Pair<Integer, Integer>> bucket;

            public Bucket() {
                bucket = new ArrayList<>();
            }

            public Integer get(Integer key) {
                for (Pair<Integer, Integer> pair : this.bucket) {
                    if (pair.first == key) {
                        return pair.second;
                    }
                }
                return -1;
            }

            public void update(Integer key, Integer value) {
                boolean found = false;
                for (Pair<Integer, Integer> pair : this.bucket) {
                    if (pair.first.equals(key)) {
                        pair.second = value;
                        found = true;
                    }
                }
                if (!found)
                    this.bucket.add(new Pair<>(key, value));
            }

            public void remove(Integer key) {
                for (Pair<Integer, Integer> pair : this.bucket) {
                    if (pair.first.equals(key)) {
                        this.bucket.remove(pair);
                        break;
                    }
                }
            }
        }
    }
}
