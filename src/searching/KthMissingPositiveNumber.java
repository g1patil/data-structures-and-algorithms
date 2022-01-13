package searching;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 * 1539. Kth Missing Positive Number
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int max = 0 ;

        int missingSum = 1 ;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max , arr[i]);
            if ( arr[i] != (i + missingSum) ){
                while (arr[i] > (i + missingSum)){
                    list.add((i + missingSum));
                    missingSum ++;
                }
            }
        }

        if (list.isEmpty())
            return arr.length + k ;

        if (list.size() < k){
            int last = k  - list.size();

            for (int i = 1 ; i <= last; i++) {
                list.add(i + max );
            }
        }

        return list.get(k - 1);

    }

    @Test
    public void test_(){
        System.out.println(findKthPositive(new int[]{5,6,7,8,9} ,9));
    }
}
