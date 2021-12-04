package practice_material.cracking_coding_interview.matrix;

import matrix.MatrixUtility;
import org.junit.Test;

/**
 * @auther g1patil
 */
public class RotateMatrix {

    int[][] matrix ;
    boolean isClockwise ;

    private int getNewRow(int oldRow){
        return oldRow ;
    }

    private int getNewColumn(int oldcolumn){
        return matrix.length - oldcolumn - 1 ;
    }

    /**
     * Returns the new coordinates based on the direction for the element in matrix.
     * @param x old row index
     * @param y old column index
     * @return returns the int array of size 2.
     * First element will be new row index and second will be new column index
     * */
    private int[] getNewCoordinates(int x , int y ){
        if (isClockwise){
            return new int[]{ y, matrix.length - x - 1 };
        } else return new int[]{matrix.length - y - 1 , x};
    }

    public void rotateMatrix(){
        if (matrix == null)
            return;

        int diagonal = matrix.length/2;

        for (int diag = 1; diag <= diagonal; diag++) {
            for (int i = diag -1 ; i < matrix[0].length - diag ; i++) {
                int count = 4 ;
                int currentRow = diag - 1  , currentColumn = i ;
                int newRow = 0 , newColumn = 0 ;
                int oldTemp = matrix[currentRow][currentColumn] , newTemp = 0  ;

                while ( count > 0){
                    newRow = getNewRow(currentColumn);
                    newColumn = getNewColumn(currentRow);
                    newTemp = matrix[newRow][newColumn];
                    matrix[newRow][newColumn] = oldTemp ;

                    oldTemp = newTemp ;
                    currentRow = newRow;
                    currentColumn = newColumn ;
                    count -- ;
                }
            }
        }

    }
    @Test
    public void test_(){
        this.matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        MatrixUtility.print(matrix);
        System.out.println("---------------------------");
        rotateMatrix();
        rotateMatrix();
        MatrixUtility.print(matrix);
    }
}
