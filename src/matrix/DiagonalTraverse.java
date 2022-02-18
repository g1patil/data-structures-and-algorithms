package matrix;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 * 498. Diagonal Traverse
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class DiagonalTraverse {

    int[][] matrix;
    List<Integer> result = new ArrayList<>();

    enum Turn {
        UP,
        DOWN
    }

    public List<Integer> findDiagonalOrder(int[][] mat) {
        matrix = mat;
        int[] current = new int[]{0,0};
        Turn turn = Turn.UP ;
        while (current!=null){
            if (turn == Turn.UP){
                current = addUp(current[0] , current[1] , result);
                turn = Turn.DOWN;
            } else {
                current = addDown(current[0] , current[1] , result);
                turn = Turn.UP;
            }
        }
        return result;
    }

    public int[] addDown(int row , int col , List<Integer> list){
        int rLimit = matrix.length;
        int cLimit = matrix[0].length;

        while (row < rLimit && col < cLimit && row >=0 && col >=0){
            list.add(matrix[row][col]);
            row++;
            col--;
        }
        return getNext(row -1  , col + 1);
    }

    public int[] addUp(int row , int col , List<Integer> list){
        int rLimit = matrix.length;
        int cLimit = matrix[0].length;

        while (row < rLimit && col < cLimit && row >=0 && col >=0){
            list.add(matrix[row][col]);
            row--;
            col++;
        }
        return getNext(row+1 , col - 1);
    }

    public int[] getNext(int row , int col){
        if(row == matrix.length - 1 && col == matrix[0].length -1)
            return null;

        if(row == 0 && col == matrix[0].length -1)
            return new int[]{row + 1 , col};

        if(row == matrix.length - 1  && col == 0 )
            return new int[]{row , col + 1};

        if (row == 0){
            return new int[]{row , col + 1};
        } else if(col == 0){
            return new int[]{row + 1 , col};
        } else if (row == matrix.length - 1){
            return new int[]{row , col + 1};
        } else if(col == matrix[0].length -1){
            return new int[]{row + 1 , col};
        }

        return null;
    }

    @Test
    public void test_(){
        int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };

        System.out.println(findDiagonalOrder(matrix));
    }

    @Test
    public void test_2(){
        int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6}
        };

        System.out.println(findDiagonalOrder(matrix));
    }

    @Test
    public void test_3(){
        int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9},
                new int[]{10,11,12}
        };

        System.out.println(findDiagonalOrder(matrix));
    }
}
