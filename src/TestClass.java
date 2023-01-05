import model.TreeNode;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {



    //1480. Running Sum of 1d Array
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i]+=nums[i];
        }
        return nums;
    }


    @Test
    public void test(){

    }
}