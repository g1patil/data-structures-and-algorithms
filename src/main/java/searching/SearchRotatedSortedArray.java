package searching;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 33. Search in Rotated Sorted Array
 *
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        int start = 0 , end = nums.length -1 ;

        while (start <= end ){
            int mid = (start + end)/2 ;

            if (nums[mid] == target)
                return mid;


            if (nums[start] <= nums[mid]){
                if (target <= nums[mid] && target >= nums[start]){
                    end = mid;
                } else {
                    start = mid + 1 ;
                }
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end]){
                    start = mid + 1 ;
                } else {
                    end = mid - 1 ;
                }
            }
        }

        return -1 ;

    }

    @Test
    public void test_(){
        int[] ints = new int[]{1 , 3};
        System.out.println(search(ints, 0));
    }
}
