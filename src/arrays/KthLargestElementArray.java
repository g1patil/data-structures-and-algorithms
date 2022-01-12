package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * */
public class KthLargestElementArray {

    /**
     * @param nums integer numbers
     * @param k , kth largest element
     * */
    private int findKthLargest(int[] nums, final int k) {
        PriorityQueue<Integer> integerSet = new PriorityQueue<>(Comparator.reverseOrder());

        if(nums.length < k)
            return 0;

        for (int number: nums){
            integerSet.add( number );
        }

        int result = 0;
        for (int i = 1; i <= k ; i++) {
            result = integerSet.poll();
        }
        return result;
    }

    private int findKthLargestOptimized(int[] nums, final int k) {
        PriorityQueue<Integer> integerSet = new PriorityQueue<>();

        if(nums.length < k)
            return 0;

        for (int number: nums){
            integerSet.add( number );
            if (integerSet.size()> k)
                integerSet.poll();
        }

        return integerSet.poll();
    }

    @Test
    public void test(){
        Assertions.assertEquals( 4, findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    @Test
    public void  test2(){
        Assertions.assertEquals(5, findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
}
