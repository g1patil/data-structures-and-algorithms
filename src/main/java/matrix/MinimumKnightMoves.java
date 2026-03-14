package matrix;

import annotation.Quality;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

@Quality(Stage.INCOMPLETE)
public class MinimumKnightMoves {

    private int[][] gird ;
    private boolean[][] visited;
    private static final int limit = 301;
    private int result = Integer.MAX_VALUE;


    private int[][] direction = {
            {2,-1},
            {2,1},

            {-2,-1},
            {-2,1},

            {-1,2},
            {1,2},

            {-1,-2},
            {1,-2}
    };

    private void init(){
        this.gird = new int[limit][limit];
        this.visited = new boolean[limit][limit];
    }
    public int minKnightMoves(int x, int y) {
        init();
        return dfs(0,0 ,x,y,0);
    }

    private int dfs(int row,int col ,int x, int y, int steps){
        if(row< 0 || col< 0 || row >= limit || col >= limit || this.visited[row][col])
            return -1;
        if(row == x && col == y){
            result = Math.min(steps,result);
        }
        this.visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col, 0});

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size ; i++) {
                int[] current = q.poll();
                if(current[0] == x && current[1] == y)
                    return current[2];

                for(int[] dir : direction){
                    int newRow = current[0] + dir[0];
                    int newCol = current[1] + dir[1];
                    int step = current[2];
                    if(isValid(newRow,newCol))
                        q.add(new int[]{newRow, newCol, step+1});
                }
            }
        }

        return -1;
    }

    private boolean isValid(int row,int col ){
        return row >= 0 && col >= 0 && row < limit && col < limit && !this.visited[row][col];
    }

    @Test
    public void test(){
        System.out.println(
                minKnightMoves(5,5)
        );
    }
}
