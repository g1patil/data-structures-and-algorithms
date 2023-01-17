package dynamicprogramming.unboundedknapsack;
import org.junit.jupiter.api.Test;
public class CoinChange {

    int[][] memoization;

    private int knapSackBottomUpUnbounded(final int[] values  , int weightCapacity, int numberOfItems){
        for (int currentNumberOfItems = 1; currentNumberOfItems < numberOfItems + 1; currentNumberOfItems++) {
            for (int currentTargetSum = 1; currentTargetSum < weightCapacity + 1; currentTargetSum++) {
                if ( values[currentNumberOfItems -1 ] <= currentTargetSum){

                    memoization[currentNumberOfItems][currentTargetSum] =
                             memoization[currentNumberOfItems][currentTargetSum - values[currentNumberOfItems -1 ] ]
                             + memoization[currentNumberOfItems -1 ][currentTargetSum] ;

                } else memoization[currentNumberOfItems][currentTargetSum] = memoization[currentNumberOfItems - 1 ][currentTargetSum] ;
            }
        }

        return memoization[numberOfItems][weightCapacity] ;
    }

    /**
     * Cutting the role kp problem.
     * */
    @Test
    public void test2(){
        int[] coins = new int[]{1,2,5 };

        int totalValue = 5 ;
        int numberOfItems = coins.length ;

        this.memoization = new int[numberOfItems + 1 ][totalValue + 1];

        for (int i = 0; i <= coins.length ; i++) {
            for (int j = 0; j <= totalValue; j++) {
                if ( i == 0 )
                    memoization[i][j] = 0;
                if ( j == 0)
                    memoization[i][j] = 1;
            }
        }

        System.out.println( this.knapSackBottomUpUnbounded(coins  , totalValue , numberOfItems) );
    }

    /**
     * Cutting the role kp problem.
     * */
    @Test
    public void test(){
        int[] coins = new int[]{1,2,5,10};

        int totalValue = 10 ;
        int numberOfItems = coins.length ;

        this.memoization = new int[numberOfItems + 1 ][totalValue + 1];

        for (int i = 0; i <= coins.length ; i++) {
            for (int j = 0; j <= totalValue; j++) {
                if ( i == 0 )
                    memoization[i][j] = 0;
                if ( j == 0)
                    memoization[i][j] = 1;
            }
        }

        System.out.println( this.knapSackBottomUpUnbounded(coins  , totalValue , numberOfItems) );
    }
}
