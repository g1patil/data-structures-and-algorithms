package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 2078. Two Furthest Houses With Different Colors
 *
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class TwoFurthestHousesDifferentColors {

    //todo -> merge the two loops
    public int maxDistance(int[] colors) {

        int result = 0;

        int lastValue = colors[colors.length -1];

        for(int i = 0 ; i < colors.length ; i ++){
            if(colors[i]!= lastValue){
                result = Math.max(colors.length -1 - i , result);
            }
        }


        lastValue = colors[0];

        for(int i = colors.length -1; i > 0 ; i --){
            if(colors[i]!= lastValue){
                result = Math.max( result , i );
            }
        }

        return result;

    }

    //return the first element that is different than first or last element of the array
    public int maxDistanceImproved(int[] colors) {
        return -1;
    }
}
