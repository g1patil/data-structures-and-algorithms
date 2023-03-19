package matrix;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.Test;

/**
 * 463. Island Perimeter
 */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int[] start = getStartingCell(grid);
        return dfs(grid, new boolean[grid.length][grid[0].length], start[0], start[1]);
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (!isValid(row, col, grid) || visited[row][col])
            return 0;

        visited[row][col] = true;
        return getPerimeter(grid, row, col) + dfs(grid, visited, row + 1, col)
                + dfs(grid, visited, row - 1, col)
                + dfs(grid, visited, row, col + 1)
                + dfs(grid, visited, row, col - 1);
    }

    private int getPerimeter(int[][] grid, int row, int col) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int perimeter = 0;

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] == 0) {
                perimeter++;
            }
        }

        return perimeter;
    }

    private boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1;
    }

    private int[] getStartingCell(final int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        System.out.println(islandPerimeter(new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 1, 0},}));
    }
}
