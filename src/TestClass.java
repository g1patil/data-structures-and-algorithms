import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {


    /*
    * 121. Best Time to Buy and Sell Stock
    * */
    public int maxProfit(int[] prices) {
        int currentMin = Integer.MAX_VALUE;
        int profit = 0;

        for(int i : prices){
            if( i < currentMin){
                currentMin = Math.min( i , currentMin);
            }

            profit = Math.max( profit , i - currentMin);
        }
        return profit;
    }

    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}