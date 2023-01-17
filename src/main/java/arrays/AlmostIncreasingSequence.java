package arrays;

import annotation.Platform;
import annotation.Site;

/**
 * @author g1patil
 */
@Platform(Site.LEETCODE)
public class AlmostIncreasingSequence {


    private int geCount(int[] sequence , int pointer){
        return -1 ;
    }

    boolean solution(int[] sequence) {
        int count = 0 ;
        int max = Integer.MIN_VALUE;

        if(sequence.length ==2 )
            return true;

        for(int i = 1  ; i < sequence.length - 1 ; i ++){

            if(sequence[i] > sequence[i -1 ] && sequence[i] < sequence[i + 1]){

            } else {
                count ++;
            }
        }

        return count == 1 ;
    }
}
