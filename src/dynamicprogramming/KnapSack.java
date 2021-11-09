package dynamicprogramming;

import org.junit.Test;

/**
 * Solution for KnapSack problem using the DP/. Recursive approach.
 * @g1patil
 * reference : https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
 *
 * */
public class KnapSack {

    int[][] recursionResult ;

    private int knapSackSolver(final int[] values , final int[] weight , int weightCapacity, int numberOfItems ){
        if ( weightCapacity == 0 || values.length == 0 || weight.length ==0 || numberOfItems == 0)
            return 0 ;

        if ( weight[numberOfItems -1 ] <= weightCapacity){

            return Math.max(

                    values[numberOfItems - 1] + knapSackSolver(values ,
                            weight ,
                            weightCapacity - weight[numberOfItems -1 ] ,
                            numberOfItems -1
                    ) ,
                    knapSackSolver(values ,
                            weight ,
                            weightCapacity + 0 ,
                            numberOfItems -1
                    )
            );
        }

        return knapSackSolver(values , weight , weightCapacity + 0 , numberOfItems -1 );
    }

    private int memoizationKnapSack(final int[] values , final int[] weight , int weightCapacity, int numberOfItems){
        if ( weightCapacity == 0 || values.length == 0 || weight.length ==0 || numberOfItems == 0)
            return 0 ;

        if ( recursionResult[numberOfItems][weightCapacity] != -1 )
            return recursionResult[numberOfItems][weightCapacity];

        if ( weight[numberOfItems -1 ] <= weightCapacity){

            return recursionResult[numberOfItems][weightCapacity] = Math.max(

                    values[numberOfItems -1 ] + memoizationKnapSack(values ,
                            weight ,
                            weightCapacity - weight[numberOfItems -1 ] ,
                            numberOfItems -1
                    ) ,
                    memoizationKnapSack(values ,
                            weight ,
                            weightCapacity + 0 ,
                            numberOfItems -1
                    )
            );
        }

        return memoizationKnapSack(values , weight , weightCapacity + 0 , numberOfItems -1 );
    }
    @Test
    public void test(){
        int[] values = new int[]{1,2,10,3,4,6};
        int[] weight = new int[]{1,3,7,2,3,2};

        int maxWeightCapacity = 10 ;
        int currentMaxValue = 0 ;
        int numberOfItems = values.length ;

        System.out.println( this.knapSackSolver( values , weight ,  maxWeightCapacity , numberOfItems ));

        this.recursionResult = new int[numberOfItems + 1 ][maxWeightCapacity + 1];

        for (int i = 0; i < numberOfItems + 1 ; i++) {
            for (int j = 0; j < maxWeightCapacity + 1; j++) {
                recursionResult[i][j] = -1 ;
            }
        }

        System.out.println( this.memoizationKnapSack(values , weight , maxWeightCapacity , numberOfItems) );
    }
}
