package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 53 . Maximum Subarray
 *
 * Sol : the trick is to create sum array with ,
 * each cell having its own individual value
 * After that loop over, compare with previous ,
 * if their sum is larger than current cell then keep adding.
 * If lesser, then do not add.
 *
 * Keep track of the previous element at each step.
 */
@Quality(Stage.DOCUMENTED)
@Platform(Site.LEETCODE)
public class KadaneAlgo {

    /**
     * Returns the maximum continuous sub array
     * @param nums ints
     * */
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i];
        }

        int previous = nums[0] ;
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum[i] + previous > sum[i]){
                sum[i] = sum[i] + previous;
                previous = sum[i];
            } else {
                previous = sum[i];
            }

            max = Math.max( max , sum[i] );
        }

        return max;
    }

    @Test
    public void test_(){
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
