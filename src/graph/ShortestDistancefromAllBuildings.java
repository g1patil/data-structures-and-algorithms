package graph;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 * 317. Shortest Distance from All Buildings
 */
@Quality(value = Stage.TESTED)
@Platform(Site.LEETCODE)
public class ShortestDistancefromAllBuildings {

    int[][] next = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int shortestDistance(int[][] grid) {
        int row = grid.length , col = grid[0].length;
        int [][] distance = new int[row][col];
        int [][] coveredBuildings = new int[row][col];
        int totalBuildings = 0 ;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1){
                    totalBuildings++;
                    bfs(grid,distance , coveredBuildings, i , j );
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (distance[i][j] < 0 && coveredBuildings[i][j] == totalBuildings){
                    result = Math.max(result , distance[i][j]);
                }
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result * -1;
    }

    public void bfs(int[][] grid , int[][] distance ,int[][] total, int row , int col ){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        q.add(new int[]{row,col});
        visited[row][col] = true;
        int dis = 1;

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell  = q.poll();
                int r = cell[0] , c = cell[1];

                for(int[] n : next){
                    int r1 = r + n[0] , c1 = c + n[1];

                    if (isValid(grid , r1, c1) && !visited[r1][c1] ){
                        q.add(new int[]{r1,c1});
                        distance[r1][c1]= distance[r1][c1] - dis;
                        visited[r1][c1] = true;
                        total[r1][c1]++;
                    }
                }
            }
            dis++;
        }
    }

    public boolean isValid(int[][] grid , int r , int c){
        if ( r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 1 || grid[r][c] == 2)
            return false;
        return true;
    }

    @Test
    public void test_(){
        int[][] matrix = new int[][]{
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };
        System.out.println(shortestDistance(matrix));
    }

    @Test
    public void test_2(){
        int[][] matrix = new int[][]{
                {1,0,1,0,1}
        };
        System.out.println(shortestDistance(matrix));
    }
}
