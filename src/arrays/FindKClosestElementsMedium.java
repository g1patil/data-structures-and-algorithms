package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 * 658. Find K Closest Elements
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FindKClosestElementsMedium {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int index = getIndex(nums , x);

        int low = index -1 ;
        int high = low + 1;

        List<Integer> result = new ArrayList<>();

        while ( high - low - 1 < k){

            if (low == -1){
                high++;
                continue;
            }

            if( high == nums.length || Math.abs( x  - nums[low]) <= Math.abs( x  - nums[high])  ){
                low--;
            } else {
                high++;
            }
        }

        for (int i = low + 1; i < high ; i++) {
            result.add(nums[i]);
        }
        return result;
    }

    public int getIndex(int[] nums , int target){
        int low = 0 , high = nums.length - 1;

        while (low < high){
            int mid = low + (high - low)/2 ;

            if (nums[mid] < target){
                low = mid + 1 ;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                return mid;
            }
        }
        return high;
    }

    @Test
    public void test_(){
        int[] nums = new int[]{1,2,3,4,7,8,9,10,11,19};
        System.out.println(findClosestElements(nums , 4 , 8 ));
    }
}
