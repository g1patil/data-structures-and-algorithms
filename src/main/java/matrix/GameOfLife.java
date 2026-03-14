package matrix;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 289. Game of Life
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class GameOfLife {

    private static final int[][] direction = {
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 1},
            new int[]{-1, -1},
            new int[]{1, -1},
            new int[]{-1, 1},
    };

    public void gameOfLife(int[][] board){
        List<int[]> newValues = new ArrayList<>();
        int row = board.length, col = board[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int oldValue = board[i][j];
                int neighbourCount = getNeighbourValues(board, i, j);
                int newValue = getNewValue(neighbourCount, oldValue);

                if(oldValue != newValue)
                    newValues.add(new int[]{i, j, newValue});
            }
        }

        newValues.stream().forEach(
                cor -> {
                    int i = cor[0], j = cor[1], value = cor[2];
                    board[i][j] = value;
                }
        );
    }

    private int getNeighbourValues(int[][] matrix, int i, int j){
        int result = 0;
        for(int[] dir : direction) {
            int i_n = i+dir[0];
            int j_n = j+dir[1];
            result += getValue(matrix, i_n, j_n);
        }
        return result;
    }

    private int getNewValue(int neighbourCount, int oldvalue){
        if(neighbourCount < 2){
            return 0;
        } else if(neighbourCount == 2){
            return oldvalue;
        } else if(neighbourCount == 3){
            return 1;
        } else return 0;
    }

    private int getValue(int[][] matrix, int i, int j){
        return (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) ? 0 : matrix[i][j];
    }

    @Test
    public void test(){

    }
}
