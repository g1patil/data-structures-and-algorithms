package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 487. Max Consecutive Ones II
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0 , slow = 0 , fast = 0 ;
        int zeroCount = 1 ;
        while ( fast < nums.length){

            if (nums[fast] == 1){
                max = Math.max( max , fast - slow + 1);
                fast++;
                continue;
            }

            if (nums[fast] == 0 && zeroCount > 0){
                zeroCount--;
                max = Math.max( max , fast - slow + 1);
                fast++;

            } else {
                while (zeroCount <= 0){
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
                findMaxConsecutiveOnes(new int[]{0})
        );
    }
}
