package arrays.slidingwindow;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author g1patil
 * 295. Find Median from Data Stream
 */
@Platform(Site.LEETCODE)
public class MedianFinder {

    PriorityQueue<Double> max;
    PriorityQueue<Double> min;
    public MedianFinder() {
        max = new PriorityQueue<>(Comparator.reverseOrder());
        min = new PriorityQueue<>();
    }

    public void balanceHeaps(PriorityQueue bigger, PriorityQueue smaller){
        smaller.add(bigger.poll());
    }

    public void addNum(int num) {
        if (max.isEmpty() || max.peek() > num)
            max.add((double) num);
        else min.add((double) num);

        if (max.size() > min.size() + 1)
            balanceHeaps(max, min);
        else if (min.size() > max.size() + 1)
            balanceHeaps(min,max);

    }

    public double findMedian() {

        if (min.isEmpty())
            return max.peek();
        if (max.isEmpty())
            return min.peek();

        if(max.size() == min.size())
            return (max.peek() + min.peek())/2 ;

        if (max.size() > min.size())
            return max.peek();

        return min.peek();

    }

    @Test
    public void test_(){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
    }
}
