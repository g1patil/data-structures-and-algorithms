package dynamicprogramming;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 64. Minimum Path Sum
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MinimumPathSum {

    public int minPathSum(int[][] grid){
        int row = grid.length-1, col = grid[0].length-1;
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = row; i >= 0; i--) {
            for(int j = col; j >= 0; j--) {
                if(i != row && j != col){
                    dp[i][j] = grid[i][j]+Math.min(
                            dp[i][j+1],
                            dp[i+1][j]
                    );
                } else if(i == row && j != col){
                    dp[i][j] = grid[i][j]+dp[i][j+1];
                } else if(i != row && j == col){
                    dp[i][j] = grid[i][j]+dp[i+1][j];
                } else dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }


    @Test
    public void test(){
        System.out.println(
                minPathSum(
                        new int[][]{
                                {1, 3, 1},
                                {1, 5, 1},
                                {4, 2, 1},
                        }
                )
        );
    }
}
