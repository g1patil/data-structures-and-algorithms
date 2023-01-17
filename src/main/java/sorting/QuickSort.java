package sorting;

import org.junit.jupiter.api.Test;

/**
 * Implementation of the QuickSort algo. This is in-place algo.
 * */
public class QuickSort {

    private int[] inputArray ;

    /**
     * Moves the smaller elements of the array on the left and rest on the right.
     * Pivot is chosen as the last element in the array.
     * @param ints integer array
     * @param startIndex start index of the array
     * @param endIndex end index of the array
     * */
    private int sortPartition(int[] ints , int startIndex , int endIndex){
        int pivot = ints[endIndex];
        int p1 = startIndex;

        for (int index = startIndex; index < endIndex  ; index++) {
            if ( ints[index] < pivot ){
                ArrayUtility.swap(ints , index , p1 );
                p1 ++ ;
            }
        }

        ArrayUtility.swap( ints , p1  , endIndex );
        return p1 ;
    }

    /**
     * Randomized version of pivot sorting .
     * Pivot is chosen as random between the given range .
     * @param ints integer array
     * @param startIndex start index of the array
     * @param endIndex end index of the array
     * */
    private int randomizedSortPartition(int[] ints , int startIndex , int endIndex){
        int randomPivotIndex = (int) ((Math.random() * (endIndex - startIndex)) + startIndex);
        int pivot = ints[randomPivotIndex];

        int p1 = startIndex ;

        for (int index = startIndex; index < endIndex  ; index++) {
            if ( ints[index] < pivot ){
                ArrayUtility.swap(ints , index , p1 );
                p1 ++ ;
            }
        }

        ArrayUtility.swap( ints , p1  , endIndex );
        return p1 ;
    }

    /***
     * Sorts the elements of the array using the QuickSort algo.
     * @param ints ineger array
     * @param startIndex start index
     * @param endIndex end index of the array
     */
    private void quickSort(int[] ints , int startIndex , int endIndex){
        if ( startIndex >= endIndex)
            return;

        int pivotIndex  = sortPartition( ints , startIndex , endIndex);

        quickSort( ints , startIndex , pivotIndex -1 );
        quickSort( ints ,  pivotIndex + 1  , endIndex );
    }

    @Test
    public void test(){
        this.inputArray = new int[]{5,9,2,4,10,7,1,3};
        this.quickSort(this.inputArray ,  0 , this.inputArray.length -1 );

        for (int i : this.inputArray)
            System.out.println( i + " " );
    }
}
