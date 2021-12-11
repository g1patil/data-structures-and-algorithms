package dynamicprogramming.missalenious;

import org.junit.jupiter.api.Test;
/**
 * Buy and sell the stock on the specific dats to maximize the profit at the end .
 *
 * @author g1patil 
 * */
public class BuySellStock {
    private int getProfit(int[] stocks){
         return -1 ;
    }

    @Test
    public void test_(){
        System.out.println(
                getProfit(new int[]{10, 22, 5, 75, 65, 80})
        );
    }
}
