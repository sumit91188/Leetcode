package explore.hashTable;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * @author Sumit Deo
 * @Date 7/13/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/design-hashset/solution/
 */
public class HashSetLinkedList {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
    }

    private static class MyHashSet {
        private Bucket[] buckets;
        private int keyRange;

        public MyHashSet() {
            this.keyRange = 769;
            this.buckets = new Bucket[this.keyRange];
            for (int i = 0; i < keyRange; i++) {
                this.buckets[i] = new Bucket();
            }
        }

        protected int _hash(int key) {
            return key % this.keyRange;
        }

        public void add(int key) {
            int bucketIndex = this._hash(key);
            this.buckets[bucketIndex].insert(key);
        }

        public void remove(int key) {
            int bucketIndex = this._hash(key);
            this.buckets[bucketIndex].delete(key);
        }

        public boolean contains(int key) {
            int bucketIndex = this._hash(key);
            return this.buckets[bucketIndex].exists(key);
        }

        private class Bucket {
            private LinkedList<Integer> container;

            public Bucket() {
                container = new LinkedList<>();
            }

            public void insert(Integer key) {
                int index = container.indexOf(key);
                if (index == -1) {
                    container.addFirst(key);
                }
            }

            public void delete(Integer key) {
                container.remove(key);
            }

            public boolean exists(Integer key) {
                int index = container.indexOf(key);
                return index != -1;
            }
        }
    }
}
