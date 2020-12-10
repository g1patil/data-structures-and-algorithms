package recursion;
/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * 
 * 
 * Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

*/
public class AreaOfIsland {

    private boolean[][] seen;
    private int[][] input = null;
    private int getArea(int r,int c){
        if ( r < 0 ||  r >=  input.length || c  < 0 || c >= input[0].length || seen[r][c] || input[r][c] == 0){
            return 0;
        }

        seen[r][c] = true;

        return 1 + getArea(r-1, c) +
                    getArea(r+1, c) +
                    getArea(r, c-1) + 
                    getArea(r, c+1);

    }
    public int maxAreaOfIsland(int[][] grid) {
        this.input = grid;
        seen = new boolean[grid.length][grid[0].length];
        int answer = 0;
        for(int i = 0; i < grid[0].length;i++){
            for(int j = 0; j < grid.length;j++){
                answer = Math.max(answer, getArea(i,j));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] num = {
                {0,1,1,1,0,0,0},
                {0,0,1,0,0,0,0},
                {0,0,1,0,0,0,0},
        };
        System.out.println(new AreaOfIsland().maxAreaOfIsland(num));
    }
}