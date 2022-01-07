package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 35. Search Insert Position
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        if ( nums == null || nums.length == 0)
            return -1 ;
        int low = 0 ;
        int high = nums.length - 1 ;
        int mid=0;

        while(low<=high){
            mid = low + (high - low)/2;

            if(nums[mid] == target){
                return mid;
            } else if (target < nums[mid]){
                high = mid -1;
            } else {
                low = mid + 1;
            }

        }

        return (nums[mid] < target) ?  mid+1 : mid;

    }

    @Test
    public void test_(){
        System.out.println(searchInsert(new int[]{1,3,5,6} , 2));
    }
}
