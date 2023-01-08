package graph;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 741. Cherry Pickup
 * */
@Quality(Stage.INCOMPLETE)
@Platform(Site.LEETCODE)
public class CherryPickup {

    public int cherryPickup(int[][] grid) {
        return cherryPickupHelper(grid,0,0, 1 ,1 ) ;
    }

    public int cherryPickupHelper(int[][] grid , int i , int j , int row , int col){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0  )
            return 0;

        int pick = 0 ;
        if(grid[i][j] == 1){
            pick++;
        }
        return pick
                + Math.max( cherryPickupHelper(grid,i, j + col , row , col ) , cherryPickupHelper(grid,i + row , j , row , col ) );
    }

    @Test
    public void test(){
        int[][] matrix = new int[][]{
          {0,1,-1},
          {1,0,-1},
          {1,1,1},
        };

        System.out.println(cherryPickup(matrix));
    }
}
