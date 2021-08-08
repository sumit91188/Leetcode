package explore.queueAndStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Sumit Deo
 * @Date 8/6/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1368/
 */
public class MovingAverageFromDataStream {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1)); // return 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // return 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }

    private static class MovingAverage {

        Deque<Integer> deque;
        int capacity, count, windowSum;

        public MovingAverage(int maxNumOfElems) {
            deque = new ArrayDeque<>();
            capacity = maxNumOfElems;
            count = 0;
            windowSum = 0;
        }

        public double next(int elem) {
            count++;
            deque.add(elem);

            int tail = count > capacity ? deque.poll() : 0;

            windowSum = windowSum - tail + elem;
            return windowSum * 1.0 / Math.min(count, capacity);
        }
    }
}
