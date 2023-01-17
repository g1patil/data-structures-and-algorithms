package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author g1patil
 * 954. Array of Doubled Pairs
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ArrayofDoubledPairs {

    public boolean canReorderDoubled(int[] changed) {
        if(changed.length % 2 == 1)
            return false;
        Map<Integer,Integer> freq = new TreeMap<>();
        for(int n : changed){
            freq.put( n , freq.getOrDefault(n , 0 ) + 1);
        }
        for(int n : freq.keySet()){
            if(freq.get(n) ==0)
                continue;
            int d = n < 0 ? n/2 : n*2 ;
            if( (n < 0 && n % 2 != 0) || freq.get(n) > freq.getOrDefault( d  , 0 ))
                return false;
            freq.put( d , freq.get(d) -  freq.get(n));
        }
        return true;
    }
    @Test
    public void test_(){
        System.out.println(canReorderDoubled(new int[]{4,-2,2,-4}));
    }
}
