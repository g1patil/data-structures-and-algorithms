package matrix;

/**
 * 74. Search a 2D Matrix
 * Medium
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * Output: true
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * Output: false
 * Example 3:
 *
 * Input: matrix = [], target = 0
 * Output: false
 *
 * */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target){

        for(int index = 0; index < matrix.length; index ++){
            if (target <= matrix[index][matrix[index].length-1] ){
                System.out.println("The element is in row" + index);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8,9},
                {10,11,12,15}
        };

        System.out.println(new Search2DMatrix().searchMatrix(matrix, 15));
    }
}
