package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author g1patil
 * 81. Search in Rotated Sorted Array II
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SearchinRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int start = getStartingIndex(nums);
        int result = -1 ;
        if (target >= nums[start] && target <= nums[nums.length-1]){
            result = searchTarget(Arrays.copyOfRange(nums , start , nums.length ) , target);
        } else result = searchTarget(Arrays.copyOfRange(nums , 0 , start) , target);

        return result != -1 ;
    }

    public int searchTarget(int[] nums, int target){
        int low = 0 , high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target){
                high = mid -1 ;
            } else {
                low = mid + 1;
            }
        }
         return -1;
    }
    public int getStartingIndex(int[] nums){
        int low = 0 ,  high = nums.length - 1;
        while (low < high){
            int mid = low + (high - low)/2;
            if (nums[mid] > nums[high] ){
                low = mid + 1 ;
            } else{
                high = mid;
            }
        }
        return high;
    }

    @Test
    public void test_(){
        System.out.println(search(new int[]{2,5,6,0,1,2} , 3));
    }

    @Test
    public void test_2(){
        System.out.println(search(new int[]{0,0,0,0,0,0,0,0,0,1,0,0},1));
    }

}
