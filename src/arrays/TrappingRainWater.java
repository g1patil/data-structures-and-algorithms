package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */

@Quality(Stage.DOCUMENTED)
/* Note : passes 318/320 cases*/
@Platform(Site.LEETCODE)
public class TrappingRainWater {

    int res = 0 ;

    private int[] fillWater(int[] ints , int p1 , int p2 , int value){
        while (p2 != p1){
            if (ints[p1] < value){
                res+=value - ints[p1] ;
                ints[p1] = value;
            }
            p1 ++;
        }

        return ints;
    }
    public int trap(int[] height) {
        int biggestWall = getBiggest(height) ;
        int current = 1 ;
        int p1 = 0 , p2 = height.length -1 ;

        while (current <= biggestWall){
            while (height[p1] <  current){
                p1++;
            }
            while (height[p2] < current){
                p2 -- ;
            }

            current = Math.min(height[p1] , height[p2]);
            fillWater(height , p1 , p2 , current);
            current++;
            p2 = height.length -1 ;
            p1 = 0;

        }

        return res;
    }

    private int getBiggest(int[] height){
        int max = height[0];

        for (int i : height)
            max = Math.max(i , max );
        return max;
    }

    @Test
    public void test_(){
        System.out.println(trap(new int[]{0,1,0,1,2,1,2,0}));
    }
}
