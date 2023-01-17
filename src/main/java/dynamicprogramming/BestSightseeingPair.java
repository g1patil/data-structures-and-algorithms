package dynamicprogramming;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 1014. Best Sightseeing Pair
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {
        int result = 0 , current = 0 ;

        for(int n : values){
            result = Math.max( result , current + n);
            current = Math.max( current , n ) - 1 ;
        }
        return result;
    }
}
