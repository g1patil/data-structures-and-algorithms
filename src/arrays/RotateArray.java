package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 189. Rotate Array
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if(k ==0)
            return;
        int index = k > nums.length ? (nums.length - k % nums.length ): nums.length - k ;
        int[] temp = new int[nums.length];

        int j = 0 ;
        for(int i = index; i < nums.length;i++){
            temp[j++] = nums[i];
        }

        int first = 0 ;
        for(int i = j ; i < nums.length;i++){
            temp[i] = nums[first++];
        }

        for(int i = 0 ; i < nums.length ; i ++){
            nums[i] = temp[i];
        }
    }

    @Test
    public void test_(){
        int[] nums = new int[]{1};
        rotate(nums , 10);
    }
}
