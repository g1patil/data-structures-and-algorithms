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
        int start = binarySearchHelper(nums , 0 , nums.length - 1 );
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
    int result = 0 ;
    private int binarySearchHelper(int[] ints, int i, int j) {
        if (i > j || j >= ints.length || i < 0 )
            return result;
        int mid = (i + j )/2 ;
        if (mid > 0 && ints[mid] < ints[mid -1]){
            result = mid ;
            return result;
        }
        binarySearchHelper(ints , i , mid -1);
        binarySearchHelper(ints , mid + 1 , j);
        return result;
    }

    /**
     * No dups
     * */
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
        System.out.println(getStartingIndex(new int[]{2,5,6,0,1,2} ));
    }

    @Test
    public void test_2(){
        System.out.println(search(new int[]{0,0,0,0,0,0,0,0,0,1,0,0},1));
    }

}
