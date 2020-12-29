package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

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
        Set<Integer> integerSet = new TreeSet<>();

        if(nums.length < k)
            return 0;

        for (int number: nums){
            integerSet.add( number );
        }
        return (Integer) integerSet.toArray()[integerSet.size() - k];
    }

    @Test
    public void test(){
        Assert.assertEquals( 5, findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    @Test
    public void  test2(){
        Assert.assertEquals(0, findKthLargest(new int[]{1,2,3,4,5},10));
    }
}
