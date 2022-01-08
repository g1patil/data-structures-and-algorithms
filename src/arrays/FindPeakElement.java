package arrays;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

/**
 * @author jivanpatil
 * 162. Find Peak Element
 * */
@Platform(Site.LEETCODE)
public class FindPeakElement {

    int result = 0 ;

    public int findPeakElement(int[] nums, int low , int high) {
        if (result!= 0)
            return result;
        if (low > high)
            return result;

        int mid = low + (high - low)/2 ;

        if (low == 1 || high == nums.length-2){
            if (nums[0] > nums[1])
                result = 0;
            if(nums[nums.length -1] > nums[nums.length-2]){
                result = nums.length -1;
            }
        }
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid +1]){
            result =  mid;
        } else {
                findPeakElement(nums , low , mid-1);
                findPeakElement(nums , mid +1  , high);
        }

        return result;

    }

    @Test
    public void test(){
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4} , 0 , 6));
    }

    @Test
    public void test2(){
        System.out.println(findPeakElement(new int[]{1,2,3,1} , 0 , 3));
    }

    @Test
    public void test3(){
        int[] ints = new int[]{6,5,4,3,2,3,2};

        System.out.println(findPeakElement(ints , 1 , ints.length - 2));
    }

    @Test
    public void test4(){
        int[] ints = new int[]{1,2,3};

        System.out.println(findPeakElement(ints , 1 , ints.length - 2));
    }
}
