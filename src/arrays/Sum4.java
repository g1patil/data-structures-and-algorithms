package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author g1pati
 * 18. 4Sum
 * Technically an extension of the two sum.
 * Run two loops + two sum using two pointers.
 * Two sum using two pointers gives the linear result
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class Sum4 {

    public List<List<Integer>> fourSum(int[] nums , int target) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        for (int j = 0; j < nums.length - 3; j++) {
            int threeSum = target - nums[j];
            if (j == 0 || nums[j] != nums[j  -  1]){
                for (int i = j + 1 ; i < nums.length - 2 ; i++) {
                    int twoSum = threeSum - nums[ i ] ;
                    if(i == j + 1 || nums[i] != nums[i  -  1]){
                        twoSum(j , i ,i+1 , nums.length - 1 , twoSum , nums , result);
                    }
                }
            }
        }
        return result;
    }

    public void twoSum(int j , int i , int low , int high , int target , int[] nums , List<List<Integer>> result){
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum < target){
                low ++;
            } else if ( sum > target){
                high--;
            } else {
                result.add(new ArrayList<>(asList(nums[j], nums[i] , nums[low] , nums[high])));
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
        int[] nums = new int[]{2,2,2,2,2};
        System.out.println(fourSum(nums , 8));
    }
}
