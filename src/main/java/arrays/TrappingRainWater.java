package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * 42. Trapping Rain Water
 * Algo :
 * look at optimal solution.
 * Two pointer. left and right
 * create leftmax and rightMax
 *
 * while (left < right){
 *     if left element is < right element
 *       then bring everyone to your level
 *       if found bigger than you , then
 *          make that guy leftmax
 *       else add the height difference to water
 *
 *     else
 *       then bring everyone to your level
 *       if found bigger than you , then
 *          make that guy leftmax
 *       else add the height difference to water
 * }
 */
@Quality(Stage.DOCUMENTED)
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

    /**
     * Main solution.
     * @author https://leetcode.com/AndresValdes
     * */
    public int trapOptimal(int[] height){
        if(height == null || height.length == 0)
            return 0;

        int left = 0 , right = height.length -1 ;
        int leftMax = 0 , rightMax = 0 ;

        int water = 0 ;

        while(left < right){
            if(height[left] < height[right]){

                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else {
                    water+= leftMax - height[left];
                }
                left++;

            } else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else {
                    water+= rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    @Test
    public void test_(){
        System.out.println(trap(new int[]{0,1,0,1,2,1,2,0}));
    }
}
