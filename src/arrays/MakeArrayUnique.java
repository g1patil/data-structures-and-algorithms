package arrays;

import org.junit.Test;

import java.util.*;

/**
 * @auther g1patil
 * You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
 * Return the minimum number of moves to make every value in nums unique.
 * Leetcode : 945. Minimum Increment to Make Array Unique
 *
 * Algo : Sort the array first.
 * Run for loop
 *  for each element, if the element is less than equal to the previous element ,
 *                  then this element needs increment. The increment needed will be difference + 1
 *                  At each step, keep incrementing the count. count will be difference + 1 + count
 */
public class MakeArrayUnique {


    /**
     * Returns the count of increment to make the array unique.
     * Att each step only, one increment is allowed.
     * @param nums int array of numbers
     * @return total count.
     * */
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count = 0 ;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]){
                count = count + nums[i-1] - nums[i]  + 1;
                nums[i] = nums[i-1] + 1 ;
            }
        }
        return count;
    }

    @Test
    public void test_(){
        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }
}

