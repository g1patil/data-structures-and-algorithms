package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 674. Longest Continuous Increasing Subsequence
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0 ;

        int[] seqLen = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++){
            seqLen[i] = 1 ;
        }

        for(int i = 1 ; i < nums.length ; i ++){
            if(nums[ i - 1] < nums[i])
                seqLen[i] = seqLen[i-1] + seqLen[i];
        }

        int max = 0;

        for(int i : seqLen){
            max = Math.max(max , i);
        }

        return max;
    }

    public int findLengthOfLCISOptimal(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0 ;

        int count = 1 , result  = 1 ;
        for(int i = 1 ; i < nums.length ; i ++){
            if(nums[ i - 1] < nums[i]){
                count++;
            } else {
                count = 1 ;
            }
            result = Math.max(count , result);
        }

        return result;
    }
}
