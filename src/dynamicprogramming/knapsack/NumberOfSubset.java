package dynamicprogramming.knapsack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class NumberOfSubset {

    int[][] memoization ;

    private int targetSubSetSumMemoization(int[] values , int sum){
        for (int i = 0; i <= values.length ; i++) {
            for (int j = 0; j <= i  ; j++) {
                if ( j == 0 || j == i){
                    // either the previous element , previous row and same column
                    // or previous element , previous row same column with current weight removed
                    memoization[i][j] =  1 ;
                } else
                    //previous element , previous row and same weight
                    memoization[i][j] =  memoization[ i -1  ][ j - 1] +  memoization[i - 1][j]  ;
            }
        }

        return memoization[values.length][sum];
    }

    @Test
    public void test(){
        int[] values = new int[]{ 1,2,3, 4 ,5 } ;


        memoization = new int[values.length + 1 ][values.length + 1];

        System.out.println(targetSubSetSumMemoization(values , values.length ));


    }
}
