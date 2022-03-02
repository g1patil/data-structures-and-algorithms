package matrix;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 * 200. Number of Islands
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class NumberofIslands {

    public int getArea(char[][] grid , int i , int j  , boolean[][] visited){
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||  visited[i][j] || grid[i][j] == '0' )
            return 0;

        visited[i][j] = true;

        return 1 + getArea(grid , i + 1 , j , visited ) +
                getArea(grid , i - 1 , j , visited ) +
                getArea(grid , i , j + 1 , visited ) +
                getArea( grid , i , j -1 , visited  ) ;
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<Integer> sizeList = new ArrayList();
        int max = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                int size = getArea(grid , i , j , visited) ;
                if(size > 0)
                    sizeList.add(size);
            }
        }

        return sizeList.size();
    }
}
