import model.TreeNode;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {



    // 977. Squares of a Sorted Array
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int resultPointer = nums.length-1;
        int p1= 0 , p2 = nums.length - 1;

        while(p1 <= p2){
            if(nums[p1]*nums[p1] > nums[p2]*nums[p2]){
                result[resultPointer--] = nums[p1]*nums[p1] ;
                p1++;
            } else {
                result[resultPointer--] = nums[p2]*nums[p2] ;
                p2--;
            }
        }
        return result;
    }


    @Test
    public void test(){
        ArrayUtility.print(sortedSquares(new int[]{-7,-3,2,3,11}));
    }
}