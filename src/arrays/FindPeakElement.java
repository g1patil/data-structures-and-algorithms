package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author jivanpatil
 * 162. Find Peak Element
 * 852. Peak Index in a Mountain Array
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int low = 0 , high = nums.length - 1 ;

        while(low < high){
            int mid = (low + high)/2;

            if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }



    @Test
    public void test(){
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4} ));
    }

    @Test
    public void test2(){
        System.out.println(findPeakElement(new int[]{1,2,3,1} ));
    }

    @Test
    public void test3(){
        int[] ints = new int[]{6,5,4,3,2,3,2};

        System.out.println(findPeakElement(ints ));
    }

    @Test
    public void test4(){
        int[] ints = new int[]{1,2,3};

        System.out.println(findPeakElement(ints));
    }
}
