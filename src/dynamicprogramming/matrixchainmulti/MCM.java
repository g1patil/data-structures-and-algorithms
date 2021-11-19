package dynamicprogramming.matrixchainmulti;

import org.junit.Test;

public class MCM {

    int[][] memoization ;

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

    public int multiplyMemoization(int[] ints , int i , int j ){

        if ( i >= j)
            return 0 ;

        if (memoization[i][j] != -1 )
            return memoization[i][j];

        for (int k = i; k <= j -1 ; k++) {
            memoization[i][j] = multiplyMemoization(ints , i , k ) +
                    multiplyMemoization(ints , k+1 , j ) + ints[i-1]*ints[k]*ints[j];

        }
        return memoization[i][j] ;
    }

    @Test
    public void test_(){
        int[] ints = new int[]{10, 30, 5, 60 };
        System.out.println(multiplyMatrix(ints , 1 , ints.length -1 ));
    }

    @Test
    public void test_memoization(){
        int[] ints = new int[]{10, 30, 5, 60 };
        this.memoization = new int[ints.length][ints.length ];

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                    this.memoization[i][j] = -1 ;
            }
        }
        System.out.println(multiplyMemoization(ints , 1 , ints.length -1 ));
    }

}
