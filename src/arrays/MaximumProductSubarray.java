package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * //TODO
 *
 * 152. Maximum Product Subarray
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * */
public class MaximumProductSubarray {

    /**
     * Function to get the product of maximum sub array
     * @param nums integer array
     * @return product of maximum sub array
     * */
    private int maxProduct(int[] nums) {
        //TODO
        return 0;
    }

    @Test
    public void test(){
        Assertions.assertEquals(6, maxProduct(new int[]{2,3,-2,4}));
    }

    @Test
    public void test2(){
        Assertions.assertEquals(0, maxProduct(new int[]{-2,0,-1}));
    }

    @Test
    public void test3(){
        Assertions.assertEquals(2, maxProduct(new int[]{2,0}));
    }

    @Test
    public void test4(){
        Assertions.assertEquals(2, maxProduct(new int[]{1,2,-1,-99,3,0,5,6,7,-2,4}));
    }
}
