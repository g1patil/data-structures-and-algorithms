package dynamicprogramming.knapsack;

import org.junit.Test;

public class SubSetTargetSum {

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

    @Test
    public void test(){
        int[] values = new int[]{ 5,3,1,6,9,7 } ;
        System.out.println( targetSubSetSum(values , 0 , 2 ));
    }
}
