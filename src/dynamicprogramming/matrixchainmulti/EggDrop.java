package dynamicprogramming.matrixchainmulti;

import org.junit.jupiter.api.Test;

/**
 * 887. Super Egg Drop
 *
 *
 * */
public class EggDrop {

    int[][] memoization;

    public int solve(int numberOfEggs , int numberOfFloors){
        if ( numberOfFloors == 0 || numberOfFloors == 1)
            return numberOfFloors ;

        if ( numberOfEggs == 1)
            return numberOfFloors ;

        int min = Integer.MAX_VALUE ;

        for (int i = 1; i <= numberOfFloors ; i++) {
            int temp = 1 + Math.max(
                    solve( numberOfEggs -1 , i - 1 ) ,
                            solve( numberOfEggs , numberOfFloors - i  )
            );
            min = Math.min( min , temp );
        }

        return min ;

    }

    public int solveMemoisation(int numberOfEggs , int numberOfFloors){

        if ( numberOfFloors == 0 || numberOfFloors == 1)
            return numberOfFloors ;

        if ( numberOfEggs == 0 || numberOfEggs == 1)
            return numberOfFloors ;

        if ( memoization[numberOfEggs][numberOfFloors] != -1)
            return memoization[numberOfEggs][numberOfFloors] ;
        int min = Integer.MAX_VALUE ;

        for (int i = 1; i <= numberOfFloors ; i++) {
            int temp = 1 + Math.max(
                    solveMemoisation( numberOfEggs -1 , i - 1 ) ,
                    solveMemoisation( numberOfEggs , numberOfFloors - i  )
            );
            min = Math.min( min , temp );
        }

        return memoization[numberOfEggs][numberOfFloors] = min ;

    }

    @Test
    public void test_(){
        System.out.println( solve( 2 , 6 ));
    }

    @Test
    public void test_memo(){
        int numberOfFloors = 36 ;
        int numberOfEggs = 2 ;
        memoization = new int[numberOfEggs + 1 ][ numberOfFloors + 1] ;

        for (int i = 0; i <= numberOfEggs ; i++) {
            for (int j = 0; j <= numberOfFloors ; j++) {
                memoization[i][j] = -1 ;
            }
        }
        System.out.println( solveMemoisation( numberOfEggs , numberOfFloors ));
    }
}
