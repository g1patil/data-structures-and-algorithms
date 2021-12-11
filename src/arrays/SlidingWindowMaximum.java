package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 239. Sliding Window Maximum
 *
 * You are given an array of integers numbs,
 * there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 * Example 4:
 *
 * Input: nums = [9,11], k = 2
 * Output: [11]
 * Example 5:
 *
 * Input: nums = [4,-2], k = 2
 * Output: [4]
 * */
public class SlidingWindowMaximum {

    /**
     * Function to return the max for given inout array and given window size.
     * @param input  integer array
     * @param index starting index of the window
     * @param windowSize size of the window
     * @return returns integer
     * */
    private int getMaxForWindow(final int[] input,int index,final int windowSize){

        if( index>= input.length || index > input.length- windowSize){
            throw new IndexOutOfBoundsException(" Provided value index is not allowed for given window size ");
        }

        int result = input[index];

        for (int i = index ; i <  index + windowSize;i++){
            result = Math.max( result , input[i]);
        }
        return result;

    }

    /**
     * @param nums integer array
     * @param k , window size
     * @return integer array
     * */
    public int[] maxSlidingWindow(final int[] nums, final int k) {

        if( nums.length == 0 || k > nums.length ){
            return new int[]{};
        }

        int[] result = new int[nums.length-k+1];

        for ( int index = 0 ; index <= nums.length - k ; index++){
            result[index] = getMaxForWindow(nums,index,k);
        }
        return result;
    }


    /**
     * @param nums integer array
     * @param k , window size
     * @return integer array
     * */
    public int[] maxSlidingWindowOptimal(final int[] nums, final int k) {

        int previousMax;

        if( nums.length == 0 || k > nums.length ){
            return new int[]{};
        }

        if(k==1){
            return nums;
        }

        int[] result = new int[nums.length-k+1];
        result[0] = getMaxForWindow(nums,0,k);
        previousMax = result[0];
        int p=1;

        for ( int index = k ; index < nums.length ; index++){
            result[p] = Math.max( previousMax , nums[index]);
            previousMax = result[p];
            p++;
        }
        return result;
    }

    @Test
    public void test(){
        int[] result = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        Assertions.assertEquals( 6 , result.length );
        Assertions.assertArrayEquals(new int[]{3,3,5,5,6,7},result);
    }

    @Test
    public void test6(){
        int[] result = maxSlidingWindowOptimal(new int[]{1,3,-1,-3,5,3,6,7},3);
        Assertions.assertEquals( 6 , result.length );
        Assertions.assertArrayEquals(new int[]{3,3,5,5,6,7},result);
    }

    @Test
    public void test2(){
        int[] result = maxSlidingWindowOptimal(new int[]{1},1);
        Assertions.assertEquals( 1 , result.length );
        Assertions.assertArrayEquals(new int[]{1},result);
    }

    @Test
    public void test3(){
        int[] result = maxSlidingWindowOptimal(new int[]{1,-1},1);
        Assertions.assertEquals( 2 , result.length );
        Assertions.assertArrayEquals(new int[]{1,-1},result);
    }

    @Test
    public void test4(){
        int[] result = maxSlidingWindowOptimal(new int[]{9,11},2);
        Assertions.assertEquals( 1 , result.length );
        Assertions.assertArrayEquals(new int[]{11},result);
    }

    @Test
    public void test5(){
        int[] result = maxSlidingWindowOptimal(new int[]{4,-2},2);
        Assertions.assertEquals( 1 , result.length );
        Assertions.assertArrayEquals(new int[]{4},result);
    }

    //TODO
    @Test
    public void test7(){
        int[] result = maxSlidingWindowOptimal(new int[]{7,2,4},2);
        Assertions.assertEquals( 2 , result.length );
        Assertions.assertArrayEquals(new int[]{7,4},result);
    }
}
