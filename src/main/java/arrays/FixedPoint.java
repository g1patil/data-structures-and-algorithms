package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 1064. Fixed Point
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FixedPoint {

    public int fixedPoint(int[] arr) {
        int low = 0 , high = arr.length - 1;
        int result = Integer.MAX_VALUE;

        while(low < high){
            int mid = low + (high-low)/2;

            if(mid == arr[mid])
                result = Math.min( result , mid);
            if( mid <= arr[mid]){
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    @Test
    public void test(){
        System.out.println(
                fixedPoint(new int[]{-10,-5,0,3,7})
        );
    }
}
