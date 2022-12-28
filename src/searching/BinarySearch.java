package searching;

import org.junit.jupiter.api.Test;

/**
 * 704. Binary Search
 * */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int low = 0 , high = nums.length-1;

        while (low < high){
            int mid = low + (high-low)/2;

            if (target< nums[mid]){
                high = mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else return mid;
        }

        return nums[high] == target ? high : -1;
    }

    @Test
    public void test(){
        System.out.println(search(new int[]{1,2,3},5));
    }
}
