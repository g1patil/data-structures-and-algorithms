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

    /**
     * Returns the last empty box index.
     * @param matrix given matrix box
     * @param i starting row index
     * @param j starting column index
     * */
    private int getLastEmptyIndex(int[][] matrix , int i , int j){
        while (i >=0 && matrix[i][j -1] != 0){
            i--;
        }
        return i;
    }
    public int[][] reArrangeBox(int[][] box){
        int columnLength = box[0].length;

        while (columnLength > 0){

            int lastEmptyIndex = getLastEmptyIndex(box, box.length -1 , columnLength ) ;

            for ( int lastElementIndex  = lastEmptyIndex - 1 ; lastElementIndex >=0 ; lastElementIndex --){

                if (box[lastElementIndex][columnLength -1 ] != 0
                        && box[lastElementIndex][columnLength -1 ] != -1
                        && box[lastEmptyIndex][columnLength -1 ] == 0
                        ){
                    //swap the element
                    box[lastEmptyIndex][columnLength -1 ] = box[lastElementIndex][columnLength -1 ];
                    box[lastElementIndex][columnLength -1 ] = 0 ;
                    lastEmptyIndex --;
                }

                //if obstruction found then again look for new empty
                if (box[lastElementIndex][columnLength -1 ] == -1 ){
                    lastEmptyIndex = getLastEmptyIndex(box, lastElementIndex , columnLength);
                    lastElementIndex = lastEmptyIndex;
                }
            }
            columnLength -- ;
        }

        return box;

    }


    public int[][] rotateTheBox(int[][] box) {
        box = transformMatrix(box);
        return reArrangeBox(box);
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
                {1 ,1, -1, 0 , -1 , 0},
                {1 ,1, -1, -1 , 0 , 0},
                {1 ,1, 1, 0 , 1 , 0}
        };
        System.out.println("Org matrix ");
        printMatrix(matrix);
        for (int i = 0; i < 1; i++) {
            matrix = rotateTheBox(matrix);
            System.out.println("rotated");
            printMatrix(matrix);
        }


    }
}
