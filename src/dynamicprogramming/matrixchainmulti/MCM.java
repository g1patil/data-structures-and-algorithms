package dynamicprogramming.matrixchainmulti;

import org.junit.Test;

public class MCM {

    public int multiplyMatrix(int[] ints , int i , int j ){
        if ( i >= j)
            return 0 ;
        int min = Integer.MAX_VALUE ;

        for (int k = i; k <= j -1 ; k++) {
            int tempMin = multiplyMatrix(ints , i , k ) +
                    multiplyMatrix(ints , k+1 , j ) + ints[i-1]*ints[k]*ints[j];

            min = Math.min( tempMin , min );
        }
        return min ;
    }

    @Test
    public void test_(){
        int[] ints = new int[]{1, 2, 3, 4};
        System.out.println(multiplyMatrix(ints , 1 , ints.length -1 ));
    }

}
