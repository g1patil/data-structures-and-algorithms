package miscellaneous;


/***
 * Alice in the Digital World
 *
 * https://open.kattis.com/problems/alicedigital
 */

import org.junit.jupiter.api.Test;
public class AliceDigital {


    private int getSubSequence(
            int[] ints ,
            int minimum ,
            int sum ,
            int maxSum ,
            int index ,
            int lastIndexOfMin ,
            boolean visited){

        while ( index < ints.length ){
            if ( ints[index] < minimum) {
                sum = 0 ;
                index ++ ;
            } else if (ints[index]!= minimum){
                sum+= ints[index];
                index ++ ;
            } else if (!visited && ints[index] == 2){
                sum+= ints[index];
                lastIndexOfMin = index;
                index ++ ;
                visited = true ;
            } else if ( visited && ints[index] == 2 ){
                sum = 0 ;
                index = lastIndexOfMin+1;
                visited = false;
            }
            maxSum = Math.max( sum , maxSum) ;
            if ( index > ints.length){
                break;
            }
            getSubSequence( ints , minimum , sum , maxSum , index , lastIndexOfMin , visited);
        }

        return maxSum;
    }


    @Test
    public void test(){
        System.out.println(
                this.getSubSequence( new int[]{1,3,2,6,2,4},
                        2 , 0 , 0 , 0 , -1 , false)
        );
    }
}
