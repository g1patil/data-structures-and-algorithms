package arrays.slidingwindow;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 * 239. Sliding Window Maximum
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int start = 0 , end = 0 ;

        while (end < nums.length) {

            /* computation step */
            while (!queue.isEmpty() && queue.getLast() < nums[end] ){
                queue.removeLast();
            }
            queue.addLast(nums[end]);

            /* increase the window */
            if (end - start + 1  < k ){
                end ++;
            } else {

                /* compute the result , and reverse the first element operation */
                list.add(queue.peek());
                if (queue.peek() == nums[start]){
                    queue.removeFirst();
                }
                start++;
                end++;
            }
        }

        int[] result = new int[list.size()];

        for(int i = 0 ; i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

}
