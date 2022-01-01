package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashMap;
import java.util.Map;

/***
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target. You may assume that each input
 * would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 * Example 1: Input: nums = [2,7,11,15], target = 9 Output: [0,1] Output:
 * Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2: Input: nums = [3,2,4], target = 6 Output: [1,2]
 * 
 * Example 3: Input: nums = [3,3], target = 6 Output: [0,1]
 * 
 * 
 **/
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class TwoSum {

    void getTargetElements(int[] input,int targetSum){
        Map<Integer,Integer> mapOfNumbers = new HashMap<>();

        for(int index = 0;index < input.length;index ++){
            int secondNumber = targetSum - input[index];

            if(mapOfNumbers.containsKey(secondNumber)){
                System.out.println("Found the target elements.....");
                System.out.println("First element index : " +  mapOfNumbers.get(secondNumber));
                System.out.println("Second element index : " +  index);
            
            } else {
                mapOfNumbers.put(input[index], index);
            }
        }
    }

    /**
     * LC submission
     * @param nums int numbers
     * @param target target sum that we want to find pair of
     * */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer , Integer> map = new HashMap();
        for(int i = 0 ; i < nums.length ; i ++){
            int current = nums[i];

            if(map.containsKey(target - current)){
                result[0] = i ;
                result[1] = map.get(target-current);
                return result;
            } else map.put(current , i);
        }

        return result;

    }

    public static void main(String[] args) {
        new TwoSum().getTargetElements(new int[]{1,3,5,8,11}, 12);
    }
}