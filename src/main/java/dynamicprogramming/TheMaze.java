package dynamicprogramming;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 490. The Maze
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(visited,maze,start[0],start[1], destination);
    }

    private boolean dfs(boolean[][] visited , int[][] maze , int row , int col , int[] dest){
        if(row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || visited[row][col])
            return false;

        if( row == dest[0] && col == dest[1])
            return true;
        if(maze[row][col] != 1)
            visited[row][col] = true;

        if ( dfs(visited,maze,row,col+1 , dest) ||
                dfs(visited,maze,row+1,col , dest) ||
                dfs(visited,maze,row,col-1 , dest) ||
                dfs(visited,maze,row-1,col ,dest) ){
            return true;
        }

        return false;
    }

    @Test
    public void test(){
        int[][] matrix = new int[][]{
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };

        System.out.println(
                hasPath(matrix,new int[]{0,4},new int[]{4,4})
        );
    }
}
