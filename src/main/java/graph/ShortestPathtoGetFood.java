package graph;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author g1patil
 * 1730. Shortest Path to Get Food
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ShortestPathtoGetFood {

    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int getFood(char[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[] first = getStart(grid);
        q.add(first);
        int distance = 0;
        visited[first[0]][first[1]] = true;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] cell = q.poll();
                int row = cell[0], col = cell[1];

                if(grid[row][col] == '#')
                    return distance;

                for(int[] newDir : dirs) {
                    int x = newDir[0]+row;
                    int y = newDir[1]+col;

                    if(isValid(x, y, grid) && !visited[x][y]){
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }

            }
            distance++;
        }
        return -1;
    }

    private int[] getStart(char[][] grid){
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '*')
                    return new int[]{i, j};
            }
        }
        return null;
    }

    public boolean isValid(int x, int y, char[][] grid){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 'X')
            return false;
        return true;
    }

}
