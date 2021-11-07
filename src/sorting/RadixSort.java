package sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Implement the RadixSort using the java collections framework
 *
 * */
public class RadixSort {

    private int[] inputArray ;

    private void radixSort(int[] ints){
        this.inputArray = ints ;

        int MAX = Arrays.stream(this.inputArray).max().orElse(Integer.MIN_VALUE);

        for (int i = 1 ; MAX/i > 0  ; i*=10 ) {
            radixSort( i );
        }
    }

    private void radixSort( final int exp ){

        int[] frequencyArray = new int[10];

        for (int index = 0; index < inputArray.length; index++) {
            frequencyArray[ (inputArray[index]/exp) % 10 ] ++ ;
        }

        for (int index = 1 ; index < frequencyArray.length; index++) {
            frequencyArray[  index  ] += frequencyArray[  index - 1  ] ;
        }

        int[] output = new int[this.inputArray.length];

        for (int i =  inputArray.length - 1; i >=0 ;i--) {
            int value = inputArray[ i ];
            int newPosition = frequencyArray[ (inputArray[i]/exp) % 10 ] - 1 ;
            output[ newPosition ] = value ;
            frequencyArray[ (inputArray[i]/exp) % 10 ] -- ;
        }
        this.inputArray = output ;
    }

    @Test
    public void test(){
        this.inputArray = new int[]{ 623, 110 , 356 , 101 , 300 , 298 , 441 };
        this.radixSort( this.inputArray);
    }
}
