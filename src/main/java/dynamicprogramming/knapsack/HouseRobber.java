package dynamicprogramming.knapsack;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 198. House Robber
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class HouseRobber {

    /**
     * O(n) , Θ(n)
     * */
    public int rob(int[] nums) {

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

    /**
     *
     * */
    public int robOptimal(int[] nums) {

        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int dp2 = nums[0]; ;
        int dp1 = Math.max(dp2 , nums[1]) ;
        int dp  = dp1;

        for (int i = 2; i < nums.length; i++) {
            dp = Math.max( dp1,  nums[i] + dp2);
            dp2 = dp1;
            dp1 = dp;
        }

        return dp;
    }
}
