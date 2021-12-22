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

    public int getWaterCapacity(int i , int j , int[] ints){
        return Math.min(ints[i], ints[j])*Math.min(ints[i], ints[j]);
    }

    public int getMaxSumTwoNums(int[] ints){
        return getMaxSumHelper(ints, 0 , 2 );
    }

    private int getMaxSumHelper(int[] ints, int pointer, int count) {
        if (count == 0 || pointer >= ints.length)
            return 0;

        return Math.max(
                ints[pointer] + getMaxSumHelper(ints , pointer + 1 , count -1),
                getMaxSumHelper(ints , pointer + 1 , count)
        );
    }

    @Test
    public void test_(){
        System.out.println(getMaxSumTwoNums(new int[]{3,1,2,6}));
    }

    // naive n*n solution
    public int maxArea(int[] height) {
        int result = 0 ;

        for (int i = 0; i < height.length -1; i++) {
            for ( int j = i ; j < height.length; j ++){
                if (height[j] >= height[i]){
                    result = Math.max( result , Math.min(height[i] , height[j] )*Math.abs(i - j));
                }
            }
        }
        return result;
    }

    @Test
    public void test_naive(){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
