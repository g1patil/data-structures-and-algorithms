package dynamicprogramming.unboundedknapsack;

import org.junit.jupiter.api.Test;

/**
 * Problem statement : https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * */
public class CoinChange2 {

    private int findMinimumChange(final int[] values  , int remainingChange, int flag, int minimumCoins){
        if ( remainingChange == 0)
            return 0 ;

        if ( flag == values.length && remainingChange > 0)
            return -1 ;

        int currentCoin = values[flag];

        while (remainingChange > 0 ){
            if ( remainingChange >= currentCoin){
                remainingChange-=currentCoin;
                minimumCoins++;
            } else {
                flag ++ ;
                return findMinimumChange( values , remainingChange , flag , minimumCoins);
            }
        }
        return minimumCoins ;
    }


    /**
     * TODO improve this solution using the memoization technique.
     * */
    private int findMinimumChangeDP(final int[] values  , int remainingChange, int flag, int minimumCoins){
        return - 1;
    }


    @Test
    public void test(){
        int[] coins = new int[]{25, 10 ,5 };
        int totalValue = 35 ;

        System.out.println(this.findMinimumChange( coins , totalValue , 0 , 0 ));



    }

    @Test
    public void test2(){
        int[] coins = new int[]{5,2,1 };
        int totalValue = 11 ;

        System.out.println(this.findMinimumChange( coins , totalValue , 0 , 0 ));



    }
}
