package arrays;
import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author g1patil
 * 862. Shortest Subarray with Sum at Least K
 */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class ShortestSubarraywithSumatLeastK {

    public int shortestSubarray(int[] nums, int target) {
        int len = nums.length, ans = len + 1;
        long[] presum = new long[len + 1 ];

        for (int i = 0; i < len; i++)
            presum[i + 1 ] = presum[i] + nums[i];

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < presum.length; i++) {
            while (queue.size() > 0 && presum[i] - presum[queue.getFirst()] >= target)
                ans = Math.min(ans , i - queue.pollFirst() );
            while (queue.size() > 0 && presum[i] <= presum[queue.getLast()] )
                queue.pollLast();
            queue.addLast(i);
        }

        return ans <= len ? ans : -1 ;
    }

    @Test
    public void test_(){
        int[] nums = new int[]{1,2};
        System.out.println(shortestSubarray(nums , 4 ));
    }
}
