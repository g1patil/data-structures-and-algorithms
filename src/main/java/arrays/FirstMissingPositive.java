package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 41. First Missing Positive
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int[] missing = new int[nums.length + 1];

        for(int val : nums){
            if(val < missing.length && val >=0 )
                missing[val] = - 1;
        }

        int i = 1;

        for( ; i < missing.length ; i++){
            if(missing[i]!= -1)
                return i;
        }

        return i;
    }

    public int firstMissingPositiveOptimal(int[] nums) {
        int n = nums.length;

        // Base case.
        int contains = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1) {
                contains++;
                break;
            }

        if (contains == 0)
            return 1;

        for (int i = 0; i < n; i++)
            if ((nums[i] <= 0) || (nums[i] > n))
                nums[i] = 1;

        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if (a == n)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }

    @Test
    public void test_(){
        int[] ints = new int[]{1,2,3,4,5};
        System.out.println(firstMissingPositiveOptimal(ints));
    }
}
