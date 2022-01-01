package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author g1patil
 *
 * 16. 3Sum Closest
 * Sol : Convert the 3 sum to minimum difference problem.
 * At each triplet , see how closer we are to the target or say
 * if their sum and targets absolute difference is minimum as possible.
 * If the minimum is their absolute difference then current triplet will be added to the result sum.
 */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class Sum3Closest {

    int min = Integer.MAX_VALUE;

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int _result = 0 ;

        for (int i = 0; i < nums.length - 2; i++) {


                /* logic of twoTarget two summ Array after i becomes sub array and run two sum on that*/
                int low = i + 1 ;
                int high = nums.length - 1 ;
                int twoTarget = target - nums[i];

                while (low < high){

                    /* core condition logic. This assigns the minimum abs difference and assigns sum */
                    int diff = Math.abs(target - ( nums[i] + nums[low] + nums[high])) ;
                    min = Math.min( min ,  diff) ;
                    if (min == diff )
                        _result =  nums[i] + nums[low] + nums[high];

                    if ( nums[low] + nums[high] == twoTarget){

                        low++;
                        high -- ;
                    } else if ( nums[low] + nums[high] > twoTarget){
                        high --;
                    } else {
                        low ++ ;
                    }
                }

        }

        return _result;

    }

    @Test
    public void test_(){
        System.out.println(threeSumClosest(new int[]{0,0,1,2,3,5,4,6,7} , 19 ));
    }

    @Test
    public void test_2(){
        System.out.println(threeSumClosest(new int[]{0,2,1,-3} , 1 ));
    }
}
