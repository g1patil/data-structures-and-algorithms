package dynamicprogramming.matrixchainmulti;

import org.junit.Test;

public class EggDrop {

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
    @Test
    public void test_(){

        System.out.println( solve( 2 , 6 ));
    }
}
