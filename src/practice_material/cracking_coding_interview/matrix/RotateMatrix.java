package practice_material.cracking_coding_interview.matrix;

import matrix.MatrixUtility;
import org.junit.Test;

/**
 * @auther g1patil
 */
public class RotateMatrix {

    int[][] matrix ;

    private int getNewRow(int oldRow){
        return oldRow ;
    }

    private int getNewColumn(int oldcolumn){
        return matrix.length - oldcolumn - 1 ;
    }

    public void rotateMatrix(){
        if (matrix == null)
            return;

        for (int i = 0; i < matrix[0].length -1 ; i++) {
            int count = 4 ;
            int currentRow = 0 , currentColumn = i ;
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
    @Test
    public void test_(){
        this.matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotateMatrix();
        MatrixUtility.print(matrix);
    }
}
