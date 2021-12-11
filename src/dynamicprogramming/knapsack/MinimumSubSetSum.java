package dynamicprogramming.knapsack;

import org.junit.jupiter.api.Test;

/**
 * Mininum subset sum difference dp knapsack type
 * */
public class MinimumSubSetSum {

    private boolean[][] memoization ;

    private int getMinimumSubsetSumDifference(int[] values , int targetSum){
        for (int i = 1; i <= values.length ; i++) {
            for (int j = 1; j <= targetSum  ; j++) {
                if ( values[i - 1 ] <= j){
                    // either the previous element , previous row and same column
                    // or previous element , previous row same column with current weight removed
                    memoization[i][j] = ( memoization[ i -1  ][ j - values[i - 1]] || memoization[i - 1][j] ) ;
                } else
                    //previous element , previous row and same weight
                    memoization[i][j] = memoization[i -1 ][j] ;
            }
        }

        int minPointer = Integer.MAX_VALUE ;

        for (int i = targetSum; i > 0 && minPointer > 0 ; i -- ) {
            if ( memoization[values.length][i]){
                if ( targetSum - 2*i > 0)
                    minPointer = Math.min( minPointer , targetSum - 2*i);
            }
        }

        return  minPointer ;
    }

    @Test
    public void test(){
        int[] values = new int[]{ 1,2 , 7 } ;
        int targetSum = 0;
        int maxSum = 0 ;

        for ( int i : values)
            maxSum+=i ;

        targetSum = maxSum ;
        memoization = new boolean[values.length + 1 ][targetSum + 1];

        for (int i = 0; i < values.length + 1; i++) {
            for (int j = 0; j < targetSum + 1; j++) {
                if (i == 0){
                    memoization [i] [j] = false ;
                }
                if ( j == 0){
                    memoization [i] [j] = true ;
                }
            }
        }


        System.out.println( this.getMinimumSubsetSumDifference( values , maxSum));
    }
}
