package matrix;

/**
 * @auther g1patil
 */
public class MatrixUtility {

    /***
     * @param matrix input matrix
     */
    public static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /***
     * Print the matrix given the upper and lower bound on the columns.
     * @param matrix inout matrix
     * @param startColumn start column
     * @param endColumn end column. End column will be exclusive.
     */
    public static void print(int[][] matrix , int startColumn , int endColumn){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = startColumn; j < endColumn; j++) {
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
