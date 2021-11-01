package sorting;

import org.junit.Test;

/**
 * Implementation of the selection sort algo
 * https://www.youtube.com/watch?v=GUDLRan2DWM&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=2
 *
 * This is in-place algo. Useful when auxiliary memory is limited
 *
 * */
public class SelectionSort {

    int[] inputArray;

    /**
     * Function to swap the two elements in the array.
     * @param source source element index
     * @param target target element index
     * */
    private  void swapElements(final int source , final int target){
        if ( target > inputArray.length || source < 0 )
            throw new InvalidInputException();
        int temp = this.inputArray[source];
        this.inputArray[source] = this.inputArray[target];
        this.inputArray[target] = temp;
    }

    /**
     * Gets the smallest element from the array given the range.
     * @param upperBound upper-bound  of the range
     * @param lowerBound lower-bound of the range
     * @return index of the smallest element
     * */
    private int getSmallestElementIndex(final int lowerBound , final int upperBound){
        int MIN = Integer.MAX_VALUE;
        int index = -1;
        for (int i = lowerBound; i <= upperBound; i++) {
            if ( inputArray[i] < MIN){
                MIN = Math.min( inputArray[i], MIN );
                index = i ;
            }
        }
        return index;
    }

    /**
     * Sorts the elements
     * */
    private void selectionSort(){
        int SIZE = inputArray.length;
        if ( SIZE == 0)
            throw new InvalidInputException();

        for (int i = 0; i < SIZE; i++) {
            int smallestElementIndex = getSmallestElementIndex( i , SIZE -1 );
            swapElements( i , smallestElementIndex );
        }
    }

    @Test
    public void test(){
        this.inputArray = new int[]{ 5,9,2,4,10,7,1,3};
        this.selectionSort();
        for (int i : this.inputArray) {
            System.out.print(i + " " );
        }
    }
}

class InvalidInputException extends RuntimeException{
    public InvalidInputException(){
        super("Invalid input provided.");
    }
}
