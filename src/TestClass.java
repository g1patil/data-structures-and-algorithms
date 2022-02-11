import data.TreeNode;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {


    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        int[] nums = new int[envelopes.length * 2];

        int i = 0 ;
        for(int[] num : envelopes){
            Arrays.sort(num);
            nums[i++] = num[0];
            nums[i++] = num[1];
        }

        return lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        int[] memoization = memoization = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            memoization[i] = 1 ;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    memoization[i] = Math.max( memoization[j] + 1 , memoization[i] );
                }
            }
        }

        int result = 1 ;

        for (int i : memoization)
            result = Math.max(result , i );

        return result;
    }

    @Test
    public void test_(){

       int[][] ints = new int[][]{
               new int[]{5,4},
               new int[]{6,4},
               new int[]{6,7},
               new int[]{2,3}
       };

       maxEnvelopes(ints);
    }

    @Test
    public void test_2(){

       int[][] ints = new int[][]{
               new int[]{1,1},
               new int[]{1,1},
               new int[]{1,1}
       };

       maxEnvelopes(ints);
    }


}
