package arrays;

import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

/**
 * 238. Product of Array Except Self
 *
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array
 * (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 * */
public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[nums.length];

        ans[0] = 1;

        for(int i = 1 ; i < length ; i ++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int right = 1 ;

        for(int i = length -1 ; i  >= 0; i--){
            ans[i] = ans[i] * right;
            right*=nums[i];
        }

        return ans;

    }

    @Test
    public void test(){
        ArrayUtility.print(
                productExceptSelf(
                        new int[]{1,2,3,4}
                )
        );
    }
}
