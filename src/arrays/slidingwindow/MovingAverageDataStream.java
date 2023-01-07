package arrays.slidingwindow;

import annotation.Platform;
import annotation.Site;

/**
 * @author g1patil
 */
@Platform(Site.LEETCODE)
public class MovingAverageDataStream {

    private int [] window;
    private int n, insert;
    private long sum;

    /** Initialize your data structure here. */
    public MovingAverageDataStream(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
    }

    public double next(int val) {
        if (n < window.length)  n++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;

        return (double)sum / n;
    }

    public static void main(String[] args) {

            MovingAverageDataStream movingAverageDataStream = new MovingAverageDataStream(3);
            movingAverageDataStream.next(1);
            movingAverageDataStream.next(10);
            movingAverageDataStream.next(3);
            movingAverageDataStream.next(5);

    }
}
