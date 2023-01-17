package searching;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

/**
 * @author g1patil
 * 34. Find First and Last Position of Element in Sorted Array
 *
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FirstLastOccurenceOfNumber {

    public int[] searchRange(int[] nums, int target) {

        int first = firstOccurrence(nums , target);
        int last = lastOccurrence(nums , target);

        return (first == -1 || last == -1) ? new int[]{-1,-1} : new int[]{first,last};

    }

    public int firstOccurrence(int[] nums, int target) {
        int low = 0 ; int high = nums.length - 1  , mid = 0 ;
        int index = - 1 ;

        /* Array can be of length 1 */
        while ( low <= high) {
            mid = low + (high - low)/2 ;

            if (nums[mid] >= target){
                high  = mid -1 ;
            } else {
                low = mid + 1 ;
            }
            if (nums[mid] == target)
                index = mid;
        }

        return  index ;
    }

    public int lastOccurrence(int[] nums, int target) {
        int low = 0 ; int high = nums.length - 1  , mid = 0 ;
        int index = -1 ;

        /* Array can be of length 1 */
        while ( low <= high) {
            mid = low + (high - low)/2 ;

            if (nums[mid] > target){
                high  = mid -1 ;
            } else {
                low = mid + 1 ;
            }
            if (nums[mid] == target) index = mid;
        }

        return  index ;
    }

    @Test
    public void test_(){
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(lastOccurrence(nums , 8 ));
    }

    @Test
    public void test_2(){
        int[] nums = new int[]{2,2,3,3,3,3,4,4,4,4,4,4,4};
        System.out.println(lastOccurrence(nums , 3 ));
    }

    @Test
    public void test_3(){
        int[] nums = new int[]{2};
        System.out.println(firstOccurrence(nums , 2 ));
        System.out.println(lastOccurrence(nums , 2 ));
    }

    @Test
    public void test_4(){
        int[] nums = new int[]{5,7,7,8,8,10};
        ArrayUtility.print(searchRange(nums , 8));
    }

    @Test
    public void test_5(){
        int[] nums = new int[]{2};
        ArrayUtility.print(searchRange(nums , 2));
    }
}
