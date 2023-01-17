package matrix;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 62. Unique Paths
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class UniquePaths {

    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 1;
                else memo[i][j] = -1 ;
            }
        }
       return uniquePathsHelper(m-1,n-1 , m , n );
    }

    int uniquePathsHelper(int curRow , int curCol , int row , int col){
        if (memo[curRow][curCol]!= -1)
            return memo[curRow][curCol];

        if (curRow < 0 || curRow >= row || curCol < 0 || curCol >= col)
            return 0;

      return memo[curRow][curCol] =  uniquePathsHelper(curRow - 1 , curCol , row , col) +
                uniquePathsHelper(curRow  , curCol - 1  , row , col) ;
    }

    @Test
    public void test_(){
        System.out.println(uniquePaths(3,7));
    }
}
