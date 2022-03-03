package matrix;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author g1patil
 * 329. Longest Increasing Path in a Matrix
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MakingALargeIsland {

    public int[][] size;
    public int[][] grid;
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int getArea(int[][] grid , int i , int j ){
        if( size[i][j] > 0 )
            return size[i][j];

        int max = 1 ;
        int total = 0 ;
        for(int[] dirr : dirs){
            int row = i + dirr[0] , col =  j  + dirr[1];
            if( row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] <= grid[i][j])
                continue;
            int len = 1 + getArea(grid, row , col ) ;
            max = Math.max( max , len);
        }
        size[i][j] = max ;
        return max;
    }

    public int longestIncreasingPath(int[][] matrix) {
        size = new int[matrix.length][matrix[0].length];
        int result = 1 ;
        grid = matrix;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int size = getArea( grid , i , j );
                result = Math.max( result , size);
            }
        }
        return result;
    }

    @Test
    public void test_(){
        int[][] num = {
                {3,4,5},
                {4,5,6},
                {0,0,0}
        };
        longestIncreasingPath(num);
    }
}
