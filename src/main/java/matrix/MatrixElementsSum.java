package matrix;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
@Quality(Stage.TESTED)
@Platform(Site.CODESIGNAL)
public class MatrixElementsSum {

    int[] result;

    int solution(int[][] matrix) {
        result = new int[matrix[0].length];

        int columnPointer = matrix[0].length -1;
        int rowPointer = matrix.length -1 ;

        for (int i = 0; i <= columnPointer; i++) {
            int sum = 0 ;
            int row = 0;

            while (row <= rowPointer && matrix[row][i]!= 0 ){
                sum+=matrix[row][i];
                row++;
            }

            result[i] = sum;
        }

       int max = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < result.length; i++) {
            currentSum+=result[i];
        }

        return currentSum  ;
    }

    @Test
    public void test_(){

        int[][] matrix = {
                new int[]{0,1,1,2},
                new int[]{0,5,0,0},
                new int[]{2,0,3,3}
        };

        System.out.println(solution(matrix));
    }

    @Test
    public void test_2(){

        int[][] matrix = {
                new int[]{1,1,1,0},
                new int[]{0,5,0,1},
                new int[]{2,1,3,10}
        };

        System.out.println(solution(matrix));
    }
}
