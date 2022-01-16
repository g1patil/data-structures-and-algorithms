package arrays.slidingwindow;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.ArrayList;

/**
 * @author g1patil
 * Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
 *
 * Algo : Create two pointers , start and end,
 *          increase the sum
 *         if window length is less, increase end
 *         if equal, then calculate max, remove start from the sum and increase both pointers.
 */
@Quality(Stage.TESTED)
@Platform(Site.GEEKFORGEEKS)
public class MaxSumSubarrayofSizeK {

    static int maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){
        int start = 0 , end = 0 , sum = 0 , max = Integer.MIN_VALUE;

        while (end < Arr.size()){
            sum+=Arr.get(end);
            if ( end - start + 1 < K ){
                end ++;
            } else if( end - start + 1 == K){
                max = Math.max( max , sum);
                sum-=Arr.get(start);
                start++;
                end++;
            }
        }

        return max;
    }
}
