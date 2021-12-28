package dynamicprogramming.missalenious;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
/**
 * Buy and sell the stock on the specific dats to maximize the profit at the end .
 *  121. Best Time to Buy and Sell Stock
 * @author g1patil 
 * */
@Platform(Site.LEETCODE)
@Quality(value = Stage.FAILING , details = "199/211 passes")
public class BuySellStock {

    private int getProfit(int[] stocks){
         return getProfitHelper(stocks , 0 , 0 , false) ;
    }

    private int getProfitHelper(int[] stocks , int day , int balance , boolean status){
        if (day >= stocks.length)
            return 0;

        if (!status){
            return Math.max(
                    getProfitHelper(stocks , day + 1 , balance + stocks[day] , true),
                    getProfitHelper(stocks , day + 1 , balance , status)
            );
        }

        return Math.max(
                stocks[day] - balance,
                getProfitHelper(stocks , day + 1 , balance , status)
        );
    }

    @Test
    public void test_(){
        System.out.println(
                getProfit(new int[]{10, 22, 5, 75, 65, 80})
        );
    }

    @Test
    public void test_2(){
        System.out.println(
                getProfit(new int[]{2,1,2,1,0,1,2})
        );
    }
}
