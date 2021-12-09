package practice_material.cracking_coding_interview.matrix;

import matrix.MatrixUtility;
import org.junit.Test;

/**
 * @auther g1patil
 *
 * Code to rotate the NxN matrix. Rotation can be done in any direction and also
 * how many times we want to rotate.
 */
public class RotateMatrix {

    int[][] matrix ;
    boolean isClockwise ;

    /**
     * Direction enum
     * */
    enum DIRECTION{
        CLOCKWISE,
        ANTI_CLOCKWISE;
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

    /**
     * Rotates the matrix given number of times.
     * Makes the rotation in the clockwise direction if not set.
     * @param count number of times we want to rotate the matrix
     * */
    public void rotateMatrix(int count){
        for (int i = 1; i <=count ; i++) {
            rotateMatrix();
        }
    }

    /**
     * Rotates the matrix given number of times, provided the direction.
     * @param count number of times , we want to rotate the matrix
     * @param direction direction of the rotation
     * */
    public void rotateMatrix(int count, DIRECTION direction){
        if (direction != DIRECTION.ANTI_CLOCKWISE)
            this.isClockwise = true;
        for (int i = 1; i <=count ; i++) {
            rotateMatrix();
        }
    }

    /**
     * Rotates the matrix in the clock or anticlockwise direction once.
     * */
    public void rotateMatrix(){
        if (matrix == null)
            return;

        int diagonal = matrix.length/2;

        for (int diag = 1; diag <= diagonal; diag++) {
            for (int i = diag -1 ; i < matrix[0].length - diag ; i++) {
                int count = 4 ;
                int currentRow = diag - 1  , currentColumn = i ;
                int newRow , newColumn  ;
                int oldTemp = matrix[currentRow][currentColumn] , newTemp ;

                while ( count > 0){
                    int[] newCoordinate = getNewCoordinates(currentRow,currentColumn);
                    newRow = newCoordinate[0];
                    newColumn = newCoordinate[1];
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
        rotateMatrix(1 , DIRECTION.ANTI_CLOCKWISE);
        MatrixUtility.print(matrix);
    }

    @Test
    public void test_2(){
        this.matrix = new int[][]{{1}};
        MatrixUtility.print(matrix);
        System.out.println("---------------------------");
        rotateMatrix();
        MatrixUtility.print(matrix);
    }
}
