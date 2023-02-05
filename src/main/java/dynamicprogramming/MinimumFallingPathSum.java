package dynamicprogramming;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 931. Minimum Falling Path Sum
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int row = matrix.length , col = matrix[0].length;

        for (int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col ; j++) {
                dp[i][j] = matrix[i][j] + getMin(i,j,dp);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            result = Math.min(result, dp[matrix.length-1][i]);
        }
        return result;
    }

    public int getMin(int i  , int j , int[][] matrix){
        int left = i > 0 && j > 0  ? matrix[i-1][j-1] : Integer.MAX_VALUE;
        int up = matrix[i-1][j];
        int right =  j < matrix[0].length - 1  ? matrix[i-1][j+1] : Integer.MAX_VALUE;

        return Math.min( up , Math.min(left,right));
    }

    @Test
    public void test_(){
        int[][] mat = {
                {100,-42,-46,-41},
                {31,97,10,-10},
                {-58,-51,82,89},
                {51,81,69,-51}
        };

        System.out.println(minFallingPathSum(mat));
    }
}
