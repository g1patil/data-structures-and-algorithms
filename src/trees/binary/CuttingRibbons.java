package trees.binary;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 1891. Cutting Ribbons
 * Algo : Binary search and some manual computation
 *
 * min cut length = 1
 * max cut length = max length of the ribbon
 * [5,7,9]
 * length :  1 ............... 9
 * total  :  21 .............. 1
 *
 * Perform binary search on the length , if the total is >= k , then go on right side since we
 * want to increase the cut length. we want minimum/total = k .
 */
public class CuttingRibbons {

    public int maxLength(int[] ribbons, int k) {
        int high = 0 , low = 1  , result = 0 ;
        for(int i : ribbons){
            high = Math.max(high , i );
        }

        while(low <= high){
            int mid = (low + high)/2;

            boolean total = possibleCut(ribbons ,mid , k);

            if (total){
                result  = mid ;
                low = mid + 1 ;
            } else {
                high = mid - 1;
            }


        }

        return result;
    }

    public boolean possibleCut(int[] ribbons, int cut, int k ){
        int result = 0 ;

        for(int i : ribbons){
            result+= i/cut;
        }

       return result >= k;
    }

    @Test
    public void test_(){
        System.out.println(maxLength(new int[]{5,7,9} , 3));
    }
}
