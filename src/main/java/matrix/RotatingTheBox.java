package matrix;

import java.lang.reflect.Array;

/**
 * @author g1patil
 *
 * 1861. Rotating the Box
 * TODO : WIP
 *  current impl without obstruction
 */
public class RotatingTheBox< T extends Comparable> {

    private T[][] box;
    private T obstacle;
    private T empty;
    private T element;
    private final Class<? extends T> cls;

    public RotatingTheBox(T[][] box_ , T obstacle_ , T empty_ , T element_, Class<? extends T> cls_){
        box = box_;
        obstacle = obstacle_;
        empty = empty_;
        element = element_;
        cls = cls_ ;
    }

    /**
     * Returns the last empty box index.
     * @param matrix given matrix box
     * @param i starting row index
     * @param j starting column index
     * */
    private int getLastEmptyIndex(T[][] matrix , int i , int j){
        while (i >=0 && matrix[i][j -1] != empty){
            i--;
        }
        return i;
    }
    public T[][] reArrangeBox(T[][] box){
        int columnLength = box[0].length;

        while (columnLength > 0){

            int lastEmptyIndex = getLastEmptyIndex(box, box.length -1 , columnLength ) ;

            for ( int lastElementIndex  = lastEmptyIndex - 1 ; lastElementIndex >=0 ; lastElementIndex --){

                if (box[lastElementIndex][columnLength -1 ] != empty
                        && box[lastElementIndex][columnLength -1 ] != obstacle
                        && box[lastEmptyIndex][columnLength -1 ] == empty
                        ){
                    //swap the element
                    box[lastEmptyIndex][columnLength -1 ] = box[lastElementIndex][columnLength -1 ];
                    box[lastElementIndex][columnLength -1 ] = empty ;
                    lastEmptyIndex --;
                }

                //if obstruction found then again look for new empty
                if (box[lastElementIndex][columnLength -1 ] == obstacle ){
                    lastEmptyIndex = getLastEmptyIndex(box, lastElementIndex , columnLength);
                    lastElementIndex = lastEmptyIndex;
                }
            }
            columnLength -- ;
        }

        return box;

    }


    public T[][] rotateTheBox(T[][] box) {
        box = transformMatrix(box);
        return reArrangeBox(box);
    }

    private T[][] transformMatrix( T[][] box) {
        @SuppressWarnings("unchecked")
        T[][] matrix = (T[][]) Array.newInstance(cls , box[0].length, box.length);

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                matrix[j][box.length - i - 1] = box[i][j] ;
            }
        }

        return matrix;
    }

    private void printMatrix(T[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print( matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][]{
                {1 ,1, -1, 0 , -1 , 0},
                {1 ,1, -1, -1 , 0 , 0},
                {1 ,1, 1, 0 , 1 , 0}
        };
        RotatingTheBox<Integer> rotateObj  = new RotatingTheBox<>(matrix , -1 , 0 , 1 , Integer.class);

        rotateObj.printMatrix(matrix);
        matrix = rotateObj.rotateTheBox(matrix);
        rotateObj.printMatrix(matrix);
    }
}
