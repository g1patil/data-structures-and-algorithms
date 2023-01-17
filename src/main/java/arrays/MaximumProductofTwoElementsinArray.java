package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 1464. Maximum Product of Two Elements in an Array
 * */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class MaximumProductofTwoElementsinArray {

    public int maxProduct(int[] nums) {
        int j = 0 , i = 1 ;
        int max_i = Math.max(nums[i],nums[j]) , max_j = Math.min(nums[j],nums[i]);

        if (nums[j]>nums[i]){
            j = 1;
            i = 0;
        }

        for (int k = 2; k < nums.length; k++) {
            int current = nums[k];

            if (current >= max_i){
                max_j = max_i;
                j = i ;
                max_i = current;
                i = k;
                continue;
            }

            if (current >= max_j){
                max_j = current;
                j = k ;
            }

        }

        return (nums[i]-1)*(nums[j]-1);

    }

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println(maxProduct(nums));
    }

    @Test
    public void test2(){
        int[] nums = new int[]{3,4,5,2};
        System.out.println(maxProduct(nums));
    }

    @Test
    public void test3(){
        int[] nums = new int[]{10,2,5,2};
        System.out.println(maxProduct(nums));
    }
}
