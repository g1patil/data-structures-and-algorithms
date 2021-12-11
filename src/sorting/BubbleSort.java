package sorting;

import org.junit.jupiter.api.Test;

public class BubbleSort {

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
     * Bubble sort implementation
     * */
    private void bubbleSort(){
        int SIZE = this.inputArray.length;
        for (int index = 0; index < SIZE - 2; index++) {
            for (int inner = 0 ; inner < SIZE - index - 1  ; inner++) {
                if ( this.inputArray[inner] > this.inputArray[inner+1])
                    swapElements(inner , inner + 1 );
            }
        }
    }

    @Test
    public void test(){
        this.inputArray = new int[]{ 5,9,2,4,10,7,1,3};
        this.bubbleSort();
        for (int i : this.inputArray) {
            System.out.print(i + " " );
        }
    }
}
