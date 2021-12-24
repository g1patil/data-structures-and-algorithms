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


    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums , Integer.MIN_VALUE , 0  , 0 );
    }

    @Test
    public void test_(){
        System.out.println(lengthOfLIS(new int[]{10 , 11 , 12 ,1,2 , 3 ,4 }));
    }
}
