package arrays.slidingwindow;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author g1patil
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SlidingWindowMedian {

    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();

    public void balanceHeaps(PriorityQueue bigger, PriorityQueue smaller){
        smaller.add(bigger.poll());
    }

    public void balanceHeapsHelper(){
        if (max.size() > min.size() + 1)
            balanceHeaps(max, min);
        else if (min.size() > max.size() + 1)
            balanceHeaps(min,max);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];


        for(int i = 0; i < nums.length; i++) {
            if(max.isEmpty() ||  max.peek() >  nums[i]) {
                max.add(nums[i]);
            } else {
                min.add(nums[i]);
            }

            balanceHeapsHelper();


            if(max.size() + min.size() == k) {
                double median;
                if(max.size() == min.size()) {
                    median = (double) ((long) max.peek() + (long) min.peek()) / 2;
                } else {
                    if(min.size() > max.size()){
                        median = min.peek();
                    } else if(max.size() > min.size()){
                        median = max.peek();
                    } else median = (double) max.peek();
                }

                int start = i - k + 1;
                result[start] = median;
                if(!max.remove(nums[start])) {
                    min.remove(nums[start]);
                }

                balanceHeapsHelper();
            }
        }
        return result;
    }

    @Test
    public void test_(){
        System.out.println(medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7} , 3 ));
    }
}
