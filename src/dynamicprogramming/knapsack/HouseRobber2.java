package dynamicprogramming.knapsack;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author g1patil
 * 213. House Robber II
 */
@Platform(Site.LEETCODE)
@Quality(value = Stage.TESTED)
public class HouseRobber2 {

    public int robNums(int[] nums , int index) {
        if (index>= nums.length)
            return 0;

        return Math.max( nums[index] + robNums(nums , index + 2), robNums(nums, index + 1));

    }

    /**
     * Returns the maximum amount that can be robbed/added
     * from the alternating houses.
     * @param nums int array of houses
     * */
    public int rob(int[] nums) {
        return Math.max(
                robHelper(Arrays.copyOfRange(nums , 1 , nums.length )),
                robHelper(Arrays.copyOfRange(nums , 0 , nums.length - 1))
        );
    }

    public int robHelper(int[] nums) {

        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] result = new int[nums.length];
        result[0] = nums[0]; ;
        result[1] = Math.max(result[0] , nums[1]) ;

        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max( result[i -1],  nums[i] + result[i-2]);
        }

        return result[nums.length -1];
    }

    @Test
    public void test_(){
        System.out.println(rob(new int[]{1,2,3}));
    }
}
