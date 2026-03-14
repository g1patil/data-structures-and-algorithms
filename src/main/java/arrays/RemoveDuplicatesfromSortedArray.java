package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 26. Remove Duplicates from Sorted Array
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        int slow = 0 , fast = 0  , current = Integer.MIN_VALUE;

        while( fast < nums.length){
            int[] next = getNext(nums,current,fast);

            int nextElement = next[0];
            int nextIndex = next[1];

            if(nextIndex == -1)
                break;

            nums[slow] = nextElement;
            fast = nextIndex;
            fast++;
            slow++;
            current = nextElement;
        }
        return slow;
    }

    // find the first unique which appears after current , and its index
    public int[] getNext(final int[] nums , int current , int start){
        while(start < nums.length && current == nums[start]){
            start++;
        }
        if(start >= nums.length)
            return new int[]{-1,-1};
        return new int[]{nums[start],start};
    }
}
