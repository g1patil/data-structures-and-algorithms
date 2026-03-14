package arrays;

import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * @author g1patil
 * Given , cumstom traget return group of 3 elements whose sum is equal
 * to target
 */
public class Sum3Target {


    public List<List<Integer>> threeSum(int[] nums , int target) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        for (int i = 0; i < nums.length - 2 ; i++) {
            if(i == 0 || nums[i] != nums[i  -  1]){
                twoSum(i ,i+1 , nums.length - 1 , target - nums[ i ] , nums , result);
            }
        }
        return result;
    }

    public void twoSum(int i , int low , int high , int target , int[] nums , List<List<Integer>> result){
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum < target){
                low ++;
            } else if ( sum > target){
                high--;
            } else {
                result.add(new ArrayList<>(asList(nums[i] , nums[low] , nums[high])));
                while (low < high && nums[low] == nums[low + 1])
                    low++;
                while (low < high && nums[high] == nums[high - 1])
                    high--;
                low++;
                high--;
            }
        }
    }
    @Test
    public void test_(){
        int[] nums = new int[]{1,1,1,1,1,1,1,2,2,2 , 3 ,3,3,3,3,3,3,3,3,3,4,5, 6,7,8,8,8,8,8};
        System.out.println(threeSum(nums , 12));
    }

    @Test
    public void test_2(){
        int[] nums = new int[]{1,2,3 ,4,5, 6,7,8};
        System.out.println(threeSum(nums , 12));

        int[] nums2 = new int[]{1,1,1,1,1,1,1,2,2,2 , 3 ,3,3,3,3,3,3,3,3,3,4,5, 6,7,8,8,8,8,8};
        System.out.println(threeSum(nums2 , 12));
    }

    @Test
    public void test_3(){
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums , 0));
    }

}
