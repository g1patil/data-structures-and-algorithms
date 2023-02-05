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
 * 296. Best Meeting Point
 */
@Quality(value = Stage.FAILING , details = "56/58 TLE")
@Platform(Site.LEETCODE)
public class BestMeetingPoint {

    int[][] nextCell = {{1,0},{-1,0},{0,1},{0,-1}};
    public int minTotalDistance(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    bfsDistance(grid , distance , i , j);
            }
        }
        int result = Integer.MIN_VALUE ;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (distance[i][j] < 0)
                    result = Math.max(result , distance[i][j]);
            }
        }

        return result == Integer.MIN_VALUE? 1 : result * -1;
    }

    public void bfsDistance(int[][] grid , int[][] distance , int i , int j){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i,j});
        visited[i][j] = true;
        int dis = 1 ;

        while (!q.isEmpty()){
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] current = q.poll();
                int r = current[0],c = current[1];

                for(int[] next : nextCell){
                    int r1 = r + next[0];
                    int c1 = c + next[1];

                    if (isValid(grid , r1 ,c1 ) && !visited[r1][c1]){
                        visited[r1][c1] = true;
                        distance[r1][c1] = distance[r1][c1] - dis;
                        q.add(new int[]{r1,c1});
                    }
                }
            }
            dis++;
        }
    }

    public boolean isValid(int[][] grid , int i , int j){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length ;
    }

    @Test
    public void test_(){
        int[][] matrix = {
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };
        System.out.println(minTotalDistance(matrix));
    }

    @Test
    public void test_2(){
        int[][] matrix = {
                {1,0,1,0,1}
        };
        System.out.println(minTotalDistance(matrix));
    }
}
