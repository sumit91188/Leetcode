package explore.hashTable;

import explore.binarySearchTree.BinarySearchTree;
import explore.binarySearchTree.SearchInABinarySearchTree;
import explore.binarySearchTree.TreeNode;

import java.util.LinkedList;

/**
 * @author Sumit Deo
 * @Date 7/13/21
 * @Project Leetcode
 * @Comments https://leetcode.com/problems/design-hashset/solution/
 */
public class HashSetBST {
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
            private BinarySearchTree tree;

            public Bucket() {
                tree = new BinarySearchTree();
            }

            public void insert(Integer key) {
                this.tree.root = this.tree.insert(this.tree.root, key);
            }

            public void delete(Integer key) {
                this.tree.root = this.tree.delete(this.tree.root, key);
            }

            public boolean exists(Integer key) {
                TreeNode node = this.tree.findNode(this.tree.root, key);
                return node != null;
            }
        }
    }
}
