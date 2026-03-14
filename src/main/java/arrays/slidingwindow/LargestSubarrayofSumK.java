package arrays.slidingwindow;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * Given an array containing N positive integers and an integer K.
 * Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.
 *
 * For Input:
 * 1
 * 7 5
 * 4 1 1 1 2 3 5
 * your output is:
 * 4
 */
@Platform(Site.RANDOM)
public class LargestSubarrayofSumK {

    public int getLargestSubarrayofSumK(int[] ints , int k){
        int start = 0 , end = 0 , answer = 0 , sum = 0;

        while (end < ints.length) {
            sum+=ints[end];

            if(sum < k){

            } else if ( sum == k){
                answer = Math.max( answer , end - start + 1 );
            } else {
                while ( sum > k){
                    sum-=ints[start];
                    start++;
                }
            }

            end++;
        }

        return answer;
    }

    @Test
    public void test_(){
        System.out.println(getLargestSubarrayofSumK(new int[]{4,1,1,1,2,3,5}, 5 ));
    }
}
