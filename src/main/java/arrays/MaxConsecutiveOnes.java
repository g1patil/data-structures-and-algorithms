package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 485. Max Consecutive Ones
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, slow = 0 , fast = 0 ;
        while ( fast < nums.length){

            if(nums[fast] == 1){
                max = Math.max( fast - slow + 1 , max);
                fast++;
                continue;
            }
            while ( fast < nums.length && nums[fast] == 0){
                fast++;
                slow = fast;
            }
        }
        return max;
    }

    @Test
    public void test_(){
        System.out.println(findMaxConsecutiveOnes(new int[]{0}));
    }
}
