package dynamicprogramming.knapsack;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubSetTargetSum {

    boolean[][] memoization ;

    private boolean targetSubSetSum(int[] values , int pointer , int sum){
        if ( sum == 0)
            return true;

        if ( pointer == values.length && sum > 0)
            return false ;

        if ( values[pointer] <= sum){
            int currentValue = values[pointer];
            pointer++;
            return targetSubSetSum( values , pointer , sum - currentValue) ||
                    targetSubSetSum( values , pointer , sum ) ;
        }
        pointer++ ;
        return targetSubSetSum( values , pointer , sum) ;
    }

    /**
     * Implement using the memoization.
     * */
    private boolean targetSubSetSumMemoization(int[] values , int sum){
        for (int i = 1; i <= values.length ; i++) {
            for (int j = 1; j <= sum  ; j++) {
                if ( values[i - 1 ] <= j){
                    // either the previous element , previous row and same column
                    // or previous element , previous row same column with current weight removed
                    memoization[i][j] = ( memoization[ i -1  ][ j - values[i - 1]] || memoization[i - 1][j] ) ;
                } else
                    //previous element , previous row and same weight
                    memoization[i][j] = memoization[i -1 ][j] ;
            }
        }

        return memoization[values.length][sum];
    }

    @Test
    public void test(){
        int[] values = new int[]{ 5,3,1,6,4 } ;
        int targetSum = 19 ;

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

        System.out.println(targetSubSetSum(values , 0 , targetSum ));
        Assertions.assertEquals(targetSubSetSum(values , 0 , targetSum ), targetSubSetSumMemoization(values , targetSum ));

    }

}
