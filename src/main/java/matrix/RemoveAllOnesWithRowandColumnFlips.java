package matrix;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * Remove All Ones With Row and Column Flips
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class RemoveAllOnesWithRowandColumnFlips {

    public boolean removeOnes(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1)
                flipOne(grid, -1, i);
        }

        for (int i = 1; i < grid.length; i++)
            for (int j = 1; j < grid[0].length; j++)
                if (grid[i][j] != grid[i][j-1])
                    return false;

        return true;
    }


    public void flipOne(int[][] grid , int row , int col ){
        if (col!= -1){
            int size = grid.length;
            for (int i = 0; i < size; i++) {
                grid[i][col] = grid[i][col] == 1 ? 0 : 1 ;
            }
        } else {
            int size = grid[0].length;
            for (int i = 0; i < size; i++) {
                grid[row][i] = grid[row][i] == 1 ? 0 : 1 ;
            }
        }
    }

    @Test
    public void test_(){
        int[][] matrix = {
                {0,1,0},
                {1,0,1},
                {0,1,0}
        };
        removeOnes(matrix);
    }

}
