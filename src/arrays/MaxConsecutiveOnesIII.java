package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 1004. Max Consecutive Ones III
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int max = 0 , slow = 0 , fast = 0 , zeroCount = k ;

        while ( fast < nums.length) {

            if (nums[fast] == 1){
                max = Math.max( max , fast - slow + 1);
                fast++;
                continue;
            }

            if ( nums[fast] ==0  && zeroCount > 0){
                zeroCount--;
                max = Math.max( max , fast - slow + 1);
                fast++;
            }else {
                while ( zeroCount <=0 ){
                    if (nums[slow] == 0)
                        zeroCount++;
                    slow++;
                }
            }
        }

        return max;
    }


    @Test
    public void test_(){
        System.out.println(
                longestOnes(new int[]{1,1,1,0,0,0,0,0,1,1,1,1,0,1,1,1,1} , 1)
        );
    }
}
