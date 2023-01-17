package dynamicprogramming.unboundedknapsack;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 983. Minimum Cost For Tickets
 */
public class MinimumCostForTickets {

    int[] memo = new int[365];

    /**
     * Naive recursive solution. Passes test cases but TLE
     *
     * */
    public int mincostTicketsHelper(int[] days , int[] costs , int pointer, int covered , int cost){
        if (pointer >= days.length)
            return cost;

        if ( days[pointer] <= covered){
            return mincostTicketsHelper(days , costs , pointer + 1 , covered , cost);
        }

        return Math.min(
                Math.min(
                        mincostTicketsHelper(days , costs , pointer + 1 , days[pointer] + 0 , cost + costs[0]),
                        mincostTicketsHelper(days , costs , pointer + 1 , days[pointer] + 6 , cost + costs[1])
                ),
                mincostTicketsHelper(days , costs , pointer + 1 , days[pointer] + 29 , cost + costs[2])
        );
    }

    public int mincostTickets(int[] days, int[] costs) {
        return mincostTicketsHelper(days , costs , 0 , 0 , 0);
    }

    public int mincostTicketsOptimal(int[] days, int[] costs) {
        boolean[] travelDay = new boolean[366];
        int[] minCostOnDay = new int[366];

        for (int day : days){
            travelDay[day] = true;
        }


        for (int i = 1; i < 366; i++) {
            if (!travelDay[i]){
                minCostOnDay[i] = minCostOnDay[i-1];
                continue;
            }

            int min = minCostOnDay[i -1] + costs[0];
            min = Math.min( min , costs[1] + minCostOnDay[ Math.max(0, i - 7) ] );
            min = Math.min( min , costs[2] + minCostOnDay[ Math.max(0, i - 30) ] );

            minCostOnDay[i] = min ;
        }
        return minCostOnDay[365];
    }

    @Test
    public void test_(){
        int[] days =  new int[]{1,4,6,7,8,20};
        int[] costs = new int[]{2,7,15};

        System.out.println(mincostTicketsOptimal(days,costs));
    }
}
