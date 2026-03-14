package graph;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author g1patil
 * 1293. Shortest Path in a Grid with Obstacles Elimination
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ShortestPathinaGridwithObstaclesElimination {

    int[][] direction = {
            {0,1},{1,0},{-1,0},{0,-1}
    };
    public int shortestPath(int[][] grid, int k) {
        int result =  0 ;
        Queue<int[]>  q = new LinkedList<>();
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k+1];

        q.add(new int[]{0,0,k});
        visited[0][0][0] = true;

        while (!q.isEmpty()){
            int size = q.size() ;

            for (int i = 0; i < size ; i++) {
                int[] current =  q.poll();
                int row = current[0] , col = current[1] , obs = current[2];

                if (row == grid.length - 1 && col == grid[0].length - 1 && obs >=0  ){
                    return result ;
                }

                for(int[] newDir : direction){
                    int x = newDir[0] + row;
                    int y = newDir[1] + col;
                    int newObs = obs;

                    if( isValid(x , y, grid) ){
                        newObs = grid[x][y] == 1 ? obs - 1 : obs ;

                        if ( newObs >=0 && !visited[x][y][newObs] ){
                            visited[x][y][newObs] = true;
                            q.add( new int[]{x,y , newObs});
                        }
                    }
                }
            }
            result++;
        }

        return  -1;
    }

    public boolean isValid( int x , int y , int[][] grid){
        if ( x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return false;
        return true ;
    }

    @Test
    public void test_(){
        int[][] grid = {
                {0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}
        };
        System.out.println(shortestPath(grid , 1 ));
    }
}
