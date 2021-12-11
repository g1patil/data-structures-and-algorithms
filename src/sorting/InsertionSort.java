package sorting;

import org.junit.jupiter.api.Test;

/**
 * Implementation of the Insertion sort algorithm
 * reference : https://www.youtube.com/watch?v=i-SKeOcBwko&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=4
 *
 * */
public class InsertionSort {

    int[] inputArray;

    /**
     * Sorts the array using the insertion sort algorithm steps.
     * */
    private void insertionSort(){
        for (int index = 1; index < inputArray.length ; index++) {
            int tempValue = inputArray[index];
            int holeIndex = index;

            while ( holeIndex > 0 && inputArray[holeIndex-1] >  tempValue){
                inputArray[holeIndex] = inputArray[holeIndex -1 ];
                holeIndex--;
            }

            inputArray[holeIndex] = tempValue;
        }
    }

    @Test
    public void test(){
        this.inputArray = new int[]{ 5,9,2,4,10,7,1,3};
        this.insertionSort();
        for (int i : this.inputArray) {
            System.out.print(i + " " );
        }
    }
}
