package dynamicprogramming.unboundedknapsack;

import org.junit.Test;

public class RodCutting {

    int[][] bottomUpResult ;

    private int knapSackBottomUpBounded(final int[] values , final int[] weight , int weightCapacity, int numberOfItems){
        for (int currentNumberOfItems = 1; currentNumberOfItems < numberOfItems + 1; currentNumberOfItems++) {
            for (int currentTargetSum = 1; currentTargetSum < weightCapacity + 1; currentTargetSum++) {
                if ( weight[currentNumberOfItems -1 ] <= currentTargetSum){

                    bottomUpResult[currentNumberOfItems][currentTargetSum] = Math.max(
                            values[currentNumberOfItems -1 ] + bottomUpResult[currentNumberOfItems -1][currentTargetSum - weight[currentNumberOfItems -1 ] ]
                            ,bottomUpResult[currentNumberOfItems -1 ][currentTargetSum]
                    );
                } else bottomUpResult[currentNumberOfItems][currentTargetSum] = bottomUpResult[currentNumberOfItems - 1 ][currentTargetSum] ;
            }
        }

        return bottomUpResult[numberOfItems][weightCapacity] ;
    }

    private int knapSackBottomUpUnbounded(final int[] values , final int[] weight , int weightCapacity, int numberOfItems){
        for (int currentNumberOfItems = 1; currentNumberOfItems < numberOfItems + 1; currentNumberOfItems++) {
            for (int currentTargetSum = 1; currentTargetSum < weightCapacity + 1; currentTargetSum++) {
                if ( weight[currentNumberOfItems -1 ] <= currentTargetSum){

                    bottomUpResult[currentNumberOfItems][currentTargetSum] = Math.max(
                            values[currentNumberOfItems -1 ] + bottomUpResult[currentNumberOfItems ][currentTargetSum - weight[currentNumberOfItems -1 ] ]
                            ,bottomUpResult[currentNumberOfItems -1 ][currentTargetSum]
                    );
                } else bottomUpResult[currentNumberOfItems][currentTargetSum] = bottomUpResult[currentNumberOfItems - 1 ][currentTargetSum] ;
            }
        }

        return bottomUpResult[numberOfItems][weightCapacity] ;
    }

    /**
     * Cutting the role kp problem.
     * */
    @Test
    public void test(){
        int[] weight = new int[]{1,2,3,4,5, 6, 7, 8};
        int[] values = new int[]{1,5,8,9,10,17,17,20};

        int maxWeightCapacity = 8 ;
        int numberOfItems = values.length ;

        this.bottomUpResult = new int[numberOfItems + 1 ][maxWeightCapacity + 1];

        for (int i = 0; i < numberOfItems + 1 ; i++) {
            for (int j = 0; j < maxWeightCapacity + 1; j++) {
                if ( i == 0 || j == 0)
                    bottomUpResult[i][j] = 0 ;
            }
        }

        System.out.println( this.knapSackBottomUpBounded(values , weight , maxWeightCapacity , numberOfItems) );
    }

    /**
     * Cutting the role kp problem.
     * */
    @Test
    public void test2(){
        int[] weight = new int[]{1,2,3,4,5, 6, 7, 8};
        int[] values = new int[]{10,5,8,9,10,17,17,20};

        int maxWeightCapacity = 8 ;
        int numberOfItems = values.length ;

        this.bottomUpResult = new int[numberOfItems + 1 ][maxWeightCapacity + 1];

        for (int i = 0; i < numberOfItems + 1 ; i++) {
            for (int j = 0; j < maxWeightCapacity + 1; j++) {
                if ( i == 0 || j == 0)
                    bottomUpResult[i][j] = 0 ;
            }
        }

        System.out.println( this.knapSackBottomUpUnbounded(values , weight , maxWeightCapacity , numberOfItems) );
    }


}
