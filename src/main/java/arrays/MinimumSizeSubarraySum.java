package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 209. Minimum Size Subarray Sum
 */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class MinimumSizeSubarraySum {

    public int shortestSubarray(int[] nums, int k) {
        int len = Integer.MAX_VALUE,sum = 0 ;

        for (int i = 0 ,j = 0; j < nums.length ; j++) {
            sum+=nums[j];
            while (sum >= k){
                len =  sum >= k ? Math.min( len , j - i + 1 ) : len ;
                sum-=nums[i];
                i++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    @Test
    public void test_(){
        int[] nums = new int[]{1,2,3,4,5};

        System.out.println(shortestSubarray(nums , 11 ));
    }
}
