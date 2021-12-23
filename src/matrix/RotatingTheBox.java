package matrix;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * 1861. Rotating the Box
 * TODO : WIP
 *  current impl without obstruction
 */
public class RotatingTheBox {

    //print the elements for each column starting from the bottom
    public int[][] rotateMatrix(int[][] matrix){
        int columnLength = matrix[0].length;

        while (columnLength > 0){
            int lastEmptyIndex = matrix.length -1 ;

            while (lastEmptyIndex >= 0  && matrix[lastEmptyIndex][columnLength -1] !=  0  ){
                lastEmptyIndex --;
            }

            for ( int lastElementIndex  = lastEmptyIndex - 1 ; lastElementIndex >=0 ; lastElementIndex --){
                if (matrix[lastElementIndex][columnLength -1 ] > 0 ){
                    //swap the element
                    matrix[lastEmptyIndex][columnLength -1 ] = matrix[lastElementIndex][columnLength -1 ];
                    matrix[lastElementIndex][columnLength -1 ] = 0 ;
                    lastEmptyIndex --;
                }
            }
            columnLength -- ;
        }

        return matrix;

    }


    public int[][] rotateTheBox(int[][] box) {
        box = transformMatrix(box);
        return rotateMatrix(box);
    }

    private int[][] transformMatrix(int[][] box) {
        int[][] matrix = new int[box[0].length][box.length];

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                matrix[j][box.length - i - 1] = box[i][j] ;
            }
        }

        return matrix;
    }

    private void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print( matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    @Test
    public void test_(){
        int[][] matrix = new int[][]{
                {1 ,0,0},
                {4 ,0,6},
                {0 ,0,9}
        };
        System.out.println("Org matrix ");
        printMatrix(matrix);
        for (int i = 0; i < 3; i++) {
            matrix = rotateTheBox(matrix);
            System.out.println("rotated");
            printMatrix(matrix);
        }


    }
}
