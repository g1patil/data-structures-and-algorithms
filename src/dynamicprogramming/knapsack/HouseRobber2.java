package dynamicprogramming.knapsack;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 213. House Robber II
 */
@Platform(Site.LEETCODE)
@Quality(value = Stage.BUGGY , details = "53 / 75 test cases passed.")
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
        if (nums.length ==1)
            return nums[0];
        if (nums[0] >= nums[nums.length -1]){
            nums[nums.length - 1] = 0;
            return robNums(nums , 0 );
        }
        return robNums(nums , 1 );
    }

    @Test
    public void test_(){
        System.out.println(rob(new int[]{1,2,1,1}));
    }
}
