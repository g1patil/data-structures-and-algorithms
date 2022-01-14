package searching;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
@Platform(Site.RANDOM)
public class FirstLastOccurenceOfNumber {

    public int[] searchRange(int[] nums, int target) {
        int low = 0 ; int high = nums.length - 1  , mid = 0 ;

        while ( low < high) {
            mid = low + (high - low)/2 ;

            if (nums[mid] >= target){
                high  = mid -1 ;
            } else {
                low = mid + 1 ;
            }
        }

        return null ;
    }

    public int firstOccurrence(int[] nums, int target) {
        int low = 0 ; int high = nums.length - 1  , mid = 0 ;

        while ( low < high) {
            mid = low + (high - low)/2 ;

            if (nums[mid] >= target){
                high  = mid -1 ;
            } else {
                low = mid + 1 ;
            }
        }

        return high + 1 ;
    }

    public int lastOccurrence(int[] nums, int target) {
        int low = 0 ; int high = nums.length - 1  , mid = 0 ;

        while ( low < high) {
            mid = low + (high - low)/2 ;

            if (nums[mid] > target){
                high  = mid -1 ;
            } else {
                low = mid + 1 ;
            }
        }

        return high ;
    }

    @Test
    public void test_(){
        int[] nums = new int[]{2,2,3,3,3,3,4,4,4,4,4,4,4};
        System.out.println(firstOccurrence(nums , 4 ));
    }

    @Test
    public void test_2(){
        int[] nums = new int[]{2,2,3,3,3,3,4,4,4,4,4,4,4};
        System.out.println(lastOccurrence(nums , 4 ));
    }
}
