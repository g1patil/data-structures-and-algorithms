package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 322. Coin Change
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 * Example 4:
 *
 * Input: coins = [1], amount = 1
 * Output: 1
 * Example 5:
 *
 * Input: coins = [1], amount = 2
 * Output: 2
 * */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int numberOfCoins=0;
        int lastIndex = coins.length-1;

        while ( (amount !=0) && lastIndex >= 0 ){
            int currentCoin = coins[lastIndex];

            if(currentCoin <= amount ){
                amount-=currentCoin;
                numberOfCoins++;
            } else {
                lastIndex--;
            }

        }

        if(amount > 0){
            return -1;
        }
        return numberOfCoins;
    }

    public int coinChangeOptimal(int[] coins, int amount) {
        Arrays.sort(coins);
        int numberOfCoins=0;
        int lastIndex = coins.length-1;

        while ( (amount !=0) && lastIndex >= 0 ){
            int currentCoin = coins[lastIndex];

            if(currentCoin <= amount ){
                numberOfCoins+= amount/currentCoin;
                amount = amount % currentCoin;
            } else {
                lastIndex--;
            }

        }

        if(amount > 0){
            return -1;
        }
        return numberOfCoins;
    }

    @Test
    public void test(){
        Assertions.assertEquals( 3, coinChangeOptimal(new int[]{1,2,5},11));
    }

    @Test
    public void test2(){
        Assertions.assertEquals( -1, coinChangeOptimal(new int[]{2},3));
    }

    @Test
    public void test3(){
        Assertions.assertEquals( 0, coinChangeOptimal(new int[]{1},0));
    }

    @Test
    public void test4(){
        Assertions.assertEquals( 1, coinChangeOptimal(new int[]{1},1));
    }

    @Test
    public void test5(){
        Assertions.assertEquals( 2, coinChangeOptimal(new int[]{1},2));
    }

    @Test
    public void test6(){
        Assertions.assertEquals( 4, coinChangeOptimal(new int[]{1,2,5,10},27));
    }

    @Test
    public void test7(){
        Assertions.assertEquals( -1, coinChangeOptimal(new int[]{186,419,83,408},6249));
    }
}
