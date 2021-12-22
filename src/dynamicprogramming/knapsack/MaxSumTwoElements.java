package dynamicprogramming.knapsack;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * 11. Container With Most Water
 */
@Quality(value = Stage.FAILING , details = "55/60 passes. Fails on run time")
@Platform(Site.LEETCODE)
public class MaxSumTwoElements {

    /**
     * This is standard 2 pointers method. The idea is to keep the two pointers at the
     * either end. get the area of them , and which ever side is the smaller, decrease that pointer.
     *
     * */
    public int maxArea(int[] height) {
        int result = 0 ;

        for (int i = 0 , j = height.length - 1 ; i <  j ; ) {
            result = Math.max( result , Math.min(height[i] , height[j] )*Math.abs(i - j));
            if (height[i] < height[j]){
                i ++ ;
            } else j -- ;

        }
        return result;
    }

    @Test
    public void test_naive(){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
