package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 * 974. Subarray Sums Divisible by K
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SubarraySumsDivisiblebyK {

    public int subarraysDivByK(int[] A, int k) {
        int sum = 0 ; int result = 0 ;
        Map<Integer , Integer> map = new HashMap();
        map.put(0 , 1);
        for(int n : A){
            sum = (sum + n ) % k ;

            //crux of the algo - converting the -ve sum to +ve mod. Just add the number itself to -ve mod
            if(sum < 0)
                sum+=k;
            result+=map.getOrDefault(sum , 0);
            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }
        return result;
    }
}
