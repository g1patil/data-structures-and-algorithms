package dynamicprogramming;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 70. Climbing Stairs
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ClimbingStairs {

    int[] dp ;
    public int climbStairs(int n) {
        dp = new int[n+1];
        return climbStairsHelper(n);

    }

    public int climbStairsHelper(int n) {
        if(n == 0){
            return 1;
        }

        if(n < 0)
            return 0 ;

        if(dp[n]>0)
            return dp[n];

        dp[n] = climbStairsHelper(n-1) + climbStairsHelper(n-2);
        return dp[n];
    }
}
