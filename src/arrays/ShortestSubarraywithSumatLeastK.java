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
public class ShortestSubarraywithSumatLeastK {

    public int shortestSubarray(int[] nums, int k) {
        int len = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0 ;
            for (int j = i ; j < nums.length; j++) {
                sum+=nums[j];

                if( len < j - i + 1 )
                    continue;

                if(sum == k)
                    len = Math.min( j - i + 1 , len);
            }
        }

        return len == Integer.MAX_VALUE ? - 1 : len;
    }

    @Test
    public void test_(){
        int[] nums = new int[]{48,99,37,4,-31};

        System.out.println(shortestSubarray(nums , 140 ));
    }
}
