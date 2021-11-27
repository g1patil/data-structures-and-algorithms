package matrix;

/**
 * @auther g1patil
 */
public class MatrixUtility {

    public static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean insideMatrix(int row, int column , int size){
        if ( row < 0 || column < 0 )
            return false;
        if ( row >= size || column >= size )
            return false;

        return true;
    }
}
