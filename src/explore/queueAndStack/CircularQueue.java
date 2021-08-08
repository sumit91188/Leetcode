package explore.queueAndStack;

/**
 * @author Sumit Deo
 * @Date 8/5/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1337/
 */
public class CircularQueue {
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
        int[] queue;
        int headIndex;
        int capacity;
        int count;

        public MyCircularQueue(int maxNumOfElems) {
            capacity = maxNumOfElems;
            queue = new int[capacity];
            headIndex = 0;
            count = 0;
        }

        public boolean enQueue(int elem) {
            if (isFull()) {
                return false;
            }

            queue[(headIndex + count) % capacity] = elem;
            count++;
            return true;
        }

        private boolean isEmpty() {
            return count == 0;
        }

        public int rear() {
            if (isEmpty()) {
                return -1;
            }
            int tailIndex = (headIndex + count - 1) % capacity;
            return queue[tailIndex];
        }

        public int front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[headIndex];
        }

        public boolean isFull() {
            return count == capacity;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            headIndex = (headIndex + 1) % capacity;
            count--;
            return true;
        }
    }
}
