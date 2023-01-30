package dynamicprogramming;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 72. Edit Distance
 * */
@Platform(Site.LEETCODE)
@Quality(value = Stage.FAILING,details = "1127/1146")
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length()+1];
        init(dp);
        calculateDistance(dp,word1,word2);
        return dp[dp.length-1][dp[0].length-1];
    }

    private void calculateDistance(int[][] dp ,String word1 , String word2){
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
    }

    private int getMinimum(int[][] dp , int i , int j){
        int left = getValue(dp,i,j-1);
        int up = getValue(dp,i-1,j);
        int dia = getValue(dp,i-1,j-1);

        return Math.min( left , Math.min(up,dia));
    }

    private int getValue(int[][] dp , int i , int j){
        if(i < 0 || j < 0 || i >= dp.length || j >= dp[0].length)
            return Integer.MAX_VALUE;
        return dp[i][j];
    }

    private void init(int[][] dp){
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                 if( i == 0 && j == 0){
                     dp[i][j] = 0;
                 } else dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for(int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
    }

    @Test
    public void test(){
        System.out.println(
                minDistance("azced","abcdef")
        );
    }
}
