package dynamicprogramming;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 1937. Maximum Number of Points with Cost
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MaximumNumberofPointswithCost {

    public long maxPoints(int[][] values) {
        int row = values.length,col = values[0].length;
        long[] dp = new long[col];

        for (int i = 0; i < col; i++) {
            dp[i] = values[0][i];
        }
        for (int i = 0; i < row- 1 ; i++) {

            long[] left = new long[values.length], right = new long[values.length];
            left[0] = dp[0]; right[col-1] = dp[col-1];

            for (int j = 1; j < left.length; j++)
                left[j] = Math.max( left[j-1] - 1 , dp[j]);

            for (int j = right.length - 2 ; j >= 0; j--)
                right[j] = Math.max( right[j+1] - 1 , dp[j]);

            for (int j = 0; j < dp.length; j++)
                dp[j] = values[i+1][j] + Math.max(left[j] , right[j]);
        }
        return -1;
    }

    public long getLeft(int[][] dp , int row , int col){
        long current = 0 , result = 0 ;

        for (int i = 0; i < col; i++) {
            result = Math.max( result , current + dp[row][i]);
            current = Math.max( current , dp[row][i]) - 1 ;
        }
        return result;
    }

    public long getRight(int[][] dp , int row , int col){
        long current = 0 , result = 0 ;

        for (int i = dp[0].length - 1 ; i > col; i--) {
            result = Math.max( result , current + dp[row][i]);
            current = Math.max( current , dp[row][i]) - 1 ;
        }
        return result;
    }
}
