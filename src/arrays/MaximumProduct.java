package arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 628. Maximum Product of Three Numbers
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: 6
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 24
 * Example 3:
 *
 * Input: nums = [-1,-2,-3]
 * Output: -6
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 * */
public class MaximumProduct {

    /**
     * Find two elements with largest product
     * @param nums input array of numbers
     * @return largest possible product of two number
     * */
    int maximumProduct(int[] nums){
        int p1,p2,p3,max=Integer.MIN_VALUE;
        int largestNumber=Integer.MIN_VALUE;

        for(int i=0; i < nums.length-2; i++){
            for(int j= i+1; j < nums.length-1; j++){
                for (int k = j+1; k < nums.length ; k ++){
                    max = Math.max(nums[i] * nums[j] * nums[k] , max);
                }
            }
        }
        return max ;
    }
    /**
     * @param input input array of integers
     * */
    int maximumProductLinear(int[] input){
        return 0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(9);
        minHeap.add(8);
        minHeap.add(20);

        Set<Integer> set = new TreeSet<>();
        set.add(10);
        set.
        System.out.println(minHeap.poll());

        System.out.println(new MaximumProduct().maximumProduct(new int[]{-100,-2,-3,1}));
    }
}
