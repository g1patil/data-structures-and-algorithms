package arrays.slidingwindow;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @author g1patil
 */
@Platform(Site.LEETCODE)
public class MovingAverageDataStream {

    int size, head = 0, windowSum = 0, count = 0;
    int[] queue;

    public MovingAverageDataStream(int size) {
        this.size = size;
        queue = new int[size];
    }

    public double next(int val) {
        ++count;
        // calculate the new sum by shifting the window
        int tail = (head + 1) % size;
        windowSum = windowSum - queue[tail] + val;
        // move on to the next head
        head = (head + 1) % size;
        queue[head] = val;
        return windowSum * 1.0 / Math.min(size, count);
    }

    public static void main(String[] args) {

            MovingAverageDataStream movingAverageDataStream = new MovingAverageDataStream(3);
            movingAverageDataStream.next(1);
            movingAverageDataStream.next(10);
            movingAverageDataStream.next(3);
            movingAverageDataStream.next(5);

    }
}
