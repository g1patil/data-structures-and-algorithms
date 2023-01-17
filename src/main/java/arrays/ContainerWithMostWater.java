package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 11. Container With Most Water
 */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0 , j = height.length - 1 ;
        int result = 0 ;

        while(i < j){

            result = Math.max(result , Math.min(height[i] , height[j])* Math.abs(i-j));

            if(height[i] < height[j]){
                i++;
            } else j --;
        }

        return result;
    }
}
