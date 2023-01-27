package practice.leetcode75;

import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.*;

/**
 * 2 , 3
 * */
public class TwoSum {

    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> numberIndexMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(numberIndexMap.containsKey(target - nums[i])){
                return new int[]{ numberIndexMap.get(target-nums[i]) , i };
            } else {
                numberIndexMap.put(nums[i], i);
            }
        }
        return null;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int i : nums){
            if(set.contains(i)){
                return true;
            } else set.add(i);
        }
        return false;
    }

    @Test
    public void test(){
        ArrayUtility.print(twoSum(new int[]{3,3},6));
    }
}
