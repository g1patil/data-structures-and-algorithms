package graph;

import org.junit.jupiter.api.Test;

public class UniquePathsII {

    private int count;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        dfs(0,0,
                obstacleGrid.length-1,
                obstacleGrid[0].length -1,
                obstacleGrid,visited);
        return count;
    }

    private void dfs(int r, int c, int tarRow,int tarCol, int[][] obstacleGrid, boolean[][] visited){
        if(r < 0 || c < 0 || r >= obstacleGrid.length || c >= obstacleGrid[0].length || visited[r][c]
            || obstacleGrid[r][c] == 1
        ){
            return;
        }

        if(r == tarRow && c == tarCol){
            count++;
            return;
        }

        visited[r][c] = true;

        dfs(r,c+1,tarRow,tarCol,obstacleGrid,visited);
        if(isValid(r,c+1,obstacleGrid))
            visited[r][c+1]=false;
        dfs(r+1,c,tarRow,tarCol,obstacleGrid,visited);
        if(isValid(r+1,c,obstacleGrid))
            visited[r+1][c]=false;

    }

    public boolean isValid(int r,int c , int[][] grid){
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }

    @Test
    public void test(){
        System.out.println(
                uniquePathsWithObstacles(
                        new int[][]{
                                {0,0,0,0},
                                {0,1,0,0},
                                {0,0,0,0},
                                {0,0,1,0},
                                {0,0,0,0},
                        }
                )
        );
    }
}
