package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.*;

/**
 * @author g1patil
 * 2007. Find Original Array From Doubled Array
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 == 1)
            return new int[]{};
        Map<Integer,Integer> freq = new TreeMap<>();
        int[] r = new int[changed.length/2];
        int index = 0 ;
        for(int n : changed){
            freq.put( n , freq.getOrDefault(n , 0 ) + 1);
        }
        for(int n : freq.keySet()){
            if(freq.get(n) > freq.getOrDefault(n*2 , 0 ))
                return new int[]{};
            for (int i = 0; i < freq.get(n); ++i) {
                r[index++]= n ;
                freq.put( n + n , freq.get(n+n) - 1);
            }
        }
        return r;
    }

    @Test
    public void test_(){
        ArrayUtility.print(findOriginalArray(new int[]{ 1,2,2,4 }));
    }
}
