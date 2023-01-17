package arrays;

import java.util.Arrays;

public class SetMatrixZeroes {

    /**
     * @param target element that needs me matched
     * @param column index of the column
     * @param number input array of numbers
     * @return true/false
     * */
    public boolean columnContainsElement(int[][] number,final int target,final int column){
        for (int[] ints : number) {
            if (ints[column] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param target target element that needs to be searched
     * @param input input int array
     * @return true/false
     * */
    public boolean atLeastOneTargetElement(int[] input,final int target){
        for(int number : input){
            if (number == target){
                return true;
            }
        }
        return false;
    }

    public int[][] setZeroes(int[][] matrix){
        boolean contains= false;
        int size = matrix[0].length;

        for(int columnNumber = 0; columnNumber < size  ; columnNumber ++){
            contains = columnContainsElement(matrix,0,columnNumber);
            if(contains){changeAllColumn(matrix,-1, columnNumber);}
        }

        return matrix;
    }

    public void makeAllZero(int[] array,final int target){
        Arrays.fill(array, target);
    }

    private void changeAllColumn(int[][] matrix, int i,int columnNumber) {
        for(int[] array : matrix){
            if (array[columnNumber] ==0 ){
                makeAllZero(array,-1);
                array[columnNumber] = i ;
            } else {
                array[columnNumber] = i ;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();

        int[][] matrix = new int[][]{
                {1,2,3},
                {2,0,6},
                {1,2,3}
        };

        int[][] matrix2 = new int[][]{
                {0,2,3},
                {2,5,6},
                {1,2,3}
        };

        int[][] matrix3 = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        setMatrixZeroes.setZeroes(matrix);
        setMatrixZeroes.setZeroes(matrix2);
        setMatrixZeroes.setZeroes(matrix3);
    }
}
