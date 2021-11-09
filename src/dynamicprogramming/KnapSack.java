package dynamicprogramming;

import org.junit.Test;

/**
 * Solution for KnapSack problem using the DP/. Recursive approach.
 * @g1patil
 * reference : https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
 *
 * */
public class KnapSack {

    private int knapSackSolver(final int[] values , final int[] weight , int weightCapacity, int numberOfItems , int maxValue){
        if ( weightCapacity == 0 || values.length == 0 || weight.length ==0 || numberOfItems == 0)
            return maxValue ;

        if ( weight[numberOfItems -1 ] <= weightCapacity){

            return Math.max(

                    knapSackSolver(values ,
                            weight ,
                            weightCapacity - weight[numberOfItems -1 ] ,
                            numberOfItems -1  ,
                            maxValue + values[numberOfItems - 1]
                    ) ,
                    knapSackSolver(values ,
                            weight ,
                            weightCapacity + 0 ,
                            numberOfItems -1 ,
                            maxValue
                    )
            );
        }

        return knapSackSolver(values , weight , weightCapacity + 0 , numberOfItems -1 , maxValue);
    }
    @Test
    public void test(){
        int[] values = new int[]{1,2,10,3,4,6};
        int[] weight = new int[]{1,3,7,2,3,2};

        int maxWeightCapacity = 10 ;
        int currentMaxValue = 0 ;

        System.out.println( this.knapSackSolver( values , weight ,  maxWeightCapacity , 6 , currentMaxValue));
    }
}
