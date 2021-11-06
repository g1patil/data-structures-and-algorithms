package sorting;

import org.junit.Test;

import java.util.Arrays;

public class CountingSort {

    private int[] inputInts ;

    private void countSort(){
        int MAX = Arrays.stream(this.inputInts).max().orElse(Integer.MIN_VALUE);
        int MIN = Arrays.stream(this.inputInts).min().orElse(0);

        int[] frequencyArray = new int[MAX -  MIN + 1 ];

        for (int index = 0; index < inputInts.length; index++) {
            frequencyArray[ inputInts[index] - MIN ] ++ ;
        }

        int p1 = 0 ;

        for (int i = 0; i < frequencyArray.length; i++) {

            while (frequencyArray[i] > 0 ) {
                this.inputInts[p1] = i + MIN ;
                p1 ++ ;
                frequencyArray[i] -- ;
            }
        }
    }
    @Test
    public void test(){
        this.inputInts = new int[]{5,2,7,4,-2,2};
        this.countSort();
    }
}
