package dynamicprogramming.knapsack;

import org.junit.Test;

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
     * Improve this and change this to iterative
     * */
    private boolean targetSubSetSumMemoization(int[] values , int pointer , int sum){
        int oldPointer = pointer ;
        if ( sum == 0)
            return true;
        if ( (pointer == values.length && sum > 0) || pointer > memoization.length - 1 )
            return false ;

        if ( memoization[pointer][sum])
            return true;

        if ( values[pointer] <= sum){
            int currentValue = values[pointer];
            pointer++;
            if (targetSubSetSumMemoization( values , pointer , sum - currentValue) ||
                    targetSubSetSumMemoization( values , pointer , sum ) ){
                return memoization[oldPointer][sum] = true ;
            } ;
        }
        pointer++ ;
        return memoization[oldPointer][sum] = targetSubSetSumMemoization( values , pointer , sum) ;
    }

    @Test
    public void test(){
        int[] values = new int[]{ 5,3,1,6,4 } ;
        int targetSum = 11 ;
        System.out.println( targetSubSetSum(values , 0 , targetSum ));

        memoization = new boolean[values.length + 1 ][targetSum + 1];

        for (int i = 0; i < values.length + 1; i++) {
            for (int j = 0; j < targetSum + 1; j++) {
                memoization [i] [j] = false ;
            }
        }

        System.out.println( targetSubSetSumMemoization(values , 0 , targetSum ));
    }
}
