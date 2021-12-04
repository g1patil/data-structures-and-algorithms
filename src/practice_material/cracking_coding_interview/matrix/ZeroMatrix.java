package practice_material.cracking_coding_interview.matrix;

import matrix.MatrixUtility;
import org.junit.Test;

/**
 * @auther g1patil
 */
public class ZeroMatrix {

    private int[][] matrix ;

    private void nullifyFirstElement(int row, int column){
        matrix[0][column] = 0;
        matrix[row][0] = 0 ;
    }

    private void nullifyRow(int rowIndex){
        for (int i = 0; i < matrix.length; i++) {
            matrix[rowIndex][i] = 0;
        }
    }
    private void nullifyColumn(int columnIndex){
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][columnIndex] = 0;
        }
    }

    private void makeZeroMatrix(){
        boolean firstRowZero = false ;
        boolean firstColumnZero = false ;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][i] == 0 ){
                firstRowZero = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0 ){
                firstColumnZero = true;
            }
        }

        for (int i = 1; i < matrix.length ; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[i][j] == 0){
                    nullifyFirstElement(i,j);
                }
            }
        }

        for (int i = 0; i < matrix.length && !firstRowZero ; i++) {
                if (matrix[i][0] == 0 ){
                    nullifyRow(i);
                }
        }

        for (int i = 0; i < matrix.length && !firstColumnZero; i++) {
                if (matrix[0][i] == 0 ){
                    nullifyColumn(i);
                }
        }

        if (firstRowZero)
            nullifyRow(0);
        if (firstColumnZero)
            nullifyColumn(0);
    }

    @Test
    public void test_(){
        this.matrix = new int[][]{
                {10,52,33,20},
                {10,10,27,89},
                {10,11,12,13},
                {14,15,16,0},
        };
        MatrixUtility.print(matrix);
        makeZeroMatrix();
        System.out.println("-------------------------------");
        MatrixUtility.print(matrix);
    }
}
