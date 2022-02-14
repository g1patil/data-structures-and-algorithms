package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author g1patil
 * 300. Longest Increasing Subsequence
 */
@Quality(Stage.TESTED)
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
        Arrays.fill(memoization , 1 );

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

    /**
     * Impl of solution by https://leetcode.com/hiepit
     * */
    public int getLISOptimal(int[] nums){
        ArrayList<Integer> numList = new ArrayList<>();
        int last = 0;
        for (int i : nums){

            if(numList.isEmpty()){
                numList.add(i);
                last = i ;
                continue;
            }

            if (last < i ){
                numList.add(i);
                last = i ;
            } else {
                int index = getIndex(numList , i);
                if (index == numList.size() - 1)
                    last = i ;
                numList.set(index , i );

            }



        }
        return numList.size();
    }

    public int getIndex(ArrayList<Integer> nums , int target){
        if (nums.isEmpty())
            return 0;

        int low = 0  , high = nums.size();

        while (low < high){
            int mid = (low + high)/2;

            if (nums.get(mid) < target){
                low = mid + 1 ;
            } else {
                high = mid;
            }
        }
        return high;
    }


    @Test
    public void test_4(){
        int[] nums = new int[]{7,7,7,7,7,7,7};
        System.out.println(getLISOptimal(nums));
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

    @Test
    public void test_3(){
        System.out.println(lengthOfLISMemo(new int[]{1,3,5,4,7}));
    }
}
