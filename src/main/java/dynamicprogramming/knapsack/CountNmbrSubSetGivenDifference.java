package dynamicprogramming.knapsack;

import org.junit.jupiter.api.Test;

public class CountNmbrSubSetGivenDifference {
    private int[][] memoization ;
    private int countSubSetSum(int[] values , int targetSum , int difference){

        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= targetSum ; j++) {
                if ( values[ i -1 ] <= j){
                    memoization[i][j] = memoization[i -1 ][ j - values[i -1 ]]
                            + memoization[i - 1 ][ j ];
                } else memoization[i][j] = memoization[i - 1 ][ j ];
            }
        }

        return memoization[values.length][(targetSum + difference) /2 ];
    }

    @Test
    public void test(){
        int[] values = new int[]{1,1,2,3 } ;
        int targetSum;
        int maxSum = 0 ;

        int difference = 1;
        for ( int i : values)
            maxSum+=i ;

        targetSum = maxSum ;

        this.memoization = new int[values.length +1 ][ targetSum + 1 ];

        for (int i = 0; i <= values.length ; i++) {
            for (int j = 0; j <= targetSum; j++) {
                if ( i == 0 )
                    memoization[i][j] = 0;
                if ( j == 0)
                    memoization[i][j] = 1;
            }
        }

        System.out.println( this.countSubSetSum( values , targetSum  ,  difference) );
    }
}
