package dynamicprogramming.knapsack;

import org.junit.jupiter.api.Test;

public class CountSubSetSum {

    private int[][] memoization ;
    private int countSubSetSum(int[] values , int targetSum){

        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= targetSum ; j++) {
                if ( values[ i -1 ] <= j){
                    memoization[i][j] = memoization[i -1 ][ j - values[i -1 ]]
                            + memoization[i - 1 ][ j ];
                } else memoization[i][j] = memoization[i - 1 ][ j ];
            }
        }


        return (memoization[values.length][targetSum]);

    }

    private int countSubSetSumUnbounded(int[] values , int targetSum){

        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= targetSum ; j++) {
                if ( values[ i -1 ] <= j){
                    memoization[i][j] = memoization[i ][ j - values[i -1 ]]
                            + memoization[i - 1 ][ j ];
                } else memoization[i][j] = memoization[i - 1 ][ j ];
            }
        }


        return (memoization[values.length][targetSum]);

    }

    @Test
    public void test(){
        int[] values = new int[]{ 5,3,1,6,4 , 9} ;
        int targetSum = 11;

        this.memoization = new int[values.length +1 ][ targetSum + 1 ];

        for (int i = 0; i <= values.length ; i++) {
            for (int j = 0; j <= targetSum; j++) {
                if ( i == 0 )
                    memoization[i][j] = 0;
                if ( j == 0)
                    memoization[i][j] = 1;
            }
        }

        System.out.println( this.countSubSetSum( values , targetSum));
    }

    @Test
    public void test2(){
        int[] values = new int[]{ 1,2,5} ;
        int targetSum = 5;

        this.memoization = new int[values.length +1 ][ targetSum + 1 ];

        for (int i = 0; i <= values.length ; i++) {
            for (int j = 0; j <= targetSum; j++) {
                if ( i == 0 )
                    memoization[i][j] = 0;
                if ( j == 0)
                    memoization[i][j] = 1;
            }
        }

        System.out.println( this.countSubSetSumUnbounded( values , targetSum));
    }
}
