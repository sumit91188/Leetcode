package explore.queueAndStack;

/**
 * @author Sumit Deo
 * @Date 8/5/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1337/
 */
public class CircularQueueII {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.rear());
    }

    private static class MyCircularQueue {
        private class Node {
            int val;
            Node nextNode;

            public Node(int val) {
                this.val = val;
            }
        }

        Node head, tail;
        int capacity;
        int count;

        public MyCircularQueue(int maxNumOfElems) {
            capacity = maxNumOfElems;
            count = 0;
        }

        public boolean isFull() {
            return count == capacity;
        }

        private boolean isEmpty() {
            return count == 0;
        }

        public boolean enQueue(int elem) {
            if (isFull()) {
                return false;
            }

            Node node = new Node(elem);
            if (isEmpty()) {
                head = tail = node;
            }
            else {
                tail.nextNode = node;
                tail = node;
            }

            count++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            head = head.nextNode;
            count--;
            return true;
        }

        public int rear() {
            if (isEmpty()) {
                return -1;
            }
            return tail.val;
        }

        public int front() {
            if (isEmpty()) {
                return -1;
            }
            return head.val;
        }
    }
}
