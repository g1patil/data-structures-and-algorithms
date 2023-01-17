package matrix;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * 1861. Rotating the Box
 */
public class RotateBoxLC {

    private static final char EMPTY_CHAR = '.';
    private static final char STONE = '#';
    private static final char OBSTRUCTION = '*';

    /**
     * Returns the last empty box index.
     * @param matrix given matrix box
     * @param i starting row index
     * @param j starting column index
     * */
    private int getLastEmptyIndex(char[][] matrix , int i , int j){
        while (i >=0 && matrix[i][j -1] != EMPTY_CHAR){
            i--;
        }
        return i;
    }

    public char[][] reArrangeBox(char[][] box){
        int columnLength = box[0].length;

        while (columnLength > 0){

            int lastEmptyIndex = getLastEmptyIndex(box, box.length -1 , columnLength ) ;

            for ( int lastElementIndex  = lastEmptyIndex - 1 ; lastElementIndex >=0 ; lastElementIndex --){

                if (box[lastElementIndex][columnLength -1 ] != EMPTY_CHAR
                        && box[lastElementIndex][columnLength -1 ] != OBSTRUCTION
                        && box[lastEmptyIndex][columnLength -1 ] == EMPTY_CHAR
                ){
                    //swap the element
                    box[lastEmptyIndex][columnLength -1 ] = box[lastElementIndex][columnLength -1 ];
                    box[lastElementIndex][columnLength -1 ] = EMPTY_CHAR ;
                    lastEmptyIndex --;
                }

                //if obstruction found then again look for new empty
                if (box[lastElementIndex][columnLength -1 ] == OBSTRUCTION ){
                    lastEmptyIndex = getLastEmptyIndex(box, lastElementIndex , columnLength);
                    lastElementIndex = lastEmptyIndex;
                }
            }
            columnLength -- ;
        }

        return box;

    }

    public char[][] rotateTheBox(char[][] box) {
        box = transformMatrix(box);
        return reArrangeBox(box);
    }

    /**
     * Transforms the m*n matrix to n*m
     * @param box char matrix
     * @return returns the transformed matrix
     * */
    private char[][] transformMatrix(char[][] box) {
        char[][] matrix = new char[box[0].length][box.length];

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                matrix[j][box.length - i - 1] = box[i][j] ;
            }
        }

        return matrix;
    }

    /**
     * Utility method to print the m*n matrix
     * */
    private void printMatrix(char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print( matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    @Test
    public void test_(){
        char[][] matrix = new char[][]{
                {STONE ,STONE, OBSTRUCTION, EMPTY_CHAR , OBSTRUCTION , EMPTY_CHAR},
                {STONE ,STONE, STONE, OBSTRUCTION , EMPTY_CHAR , EMPTY_CHAR},
                {STONE ,STONE, STONE, EMPTY_CHAR , STONE , EMPTY_CHAR}
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
