package arrays;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 300. Longest Increasing Subsequence
 */
@Platform(Site.LEETCODE)
public class LongestIncreasingSubsequence {

    int[] memoization;

    //naive impl - time limit exceeded
    public int lengthOfLIS(int[] nums , int previousMax , int pointer , int sequneceLength) {

        if ( pointer >= nums.length)
            return sequneceLength;

        if ( nums[pointer] > previousMax){
            return Math.max(
                    lengthOfLIS(nums ,  nums[pointer], pointer + 1  , sequneceLength + 1 ),
                    lengthOfLIS(nums ,   previousMax , pointer + 1  , sequneceLength )


            );
        }

        return lengthOfLIS(nums ,   previousMax , pointer + 1  , sequneceLength) ;
    }

    public int lengthOfLISMemo(int[] nums) {

        memoization = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            memoization[i] = 1 ;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    memoization[i] = Math.max( memoization[j] + 1 , memoization[i] );
                }
            }
        }

        int result = 1 ;

        for (int i : memoization)
            result = Math.max(result , i );

        return result;
    }


    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums , Integer.MIN_VALUE , 0  , 0 );
    }

    @Test
    public void test_(){
        System.out.println(lengthOfLISMemo(new int[]{10 , 11 , 12 ,1,2 , 3 ,4 }));
    }

    @Test
    public void test_2(){
        System.out.println(lengthOfLISMemo(new int[]{7,7,7,7,7,7,7}));
    }
}
