package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author g1patil
 * 15. 3Sum
 *
 * Solution : first build the target two sum using the two pointer.
 * Convert the target two sum two pointer to 3SUM
 * Find the edge cases and add the condition according to it.
 */
@Quality(Stage.DOCUMENTED)
@Platform(Site.LEETCODE)
public class SUM3 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if(i == 0 || ( i > 0 && nums[i] != nums[i-1])){

                /* logic of target two sum Array after i becomes sub array and run two sum on that*/
                int low = i + 1 ;
                int high = nums.length - 1 ;
                int target = 0 - nums[i];

                while (low < high){
                    if (nums[i] + nums[low] + nums[high] == 0){
                        List r1 = new ArrayList();
                        r1.add(nums[i]);
                        r1.add(nums[low]);
                        r1.add(nums[high]);
                        result.add(r1);

                        /* ex -2 ,0,0,0,2,2,2 here increase/decrease until we find diff number for low and high*/
                        while( low < high && nums[low] == nums[low + 1])
                            low++;
                        while( low < high && nums[high] == nums[high - 1])
                            high--;

                        low++;
                        high -- ;
                    } else if ( nums[low] + nums[high] > target){
                        high --;
                    } else {
                        low ++ ;
                    }
                }
            }

        }

        return result;

    }

    @Test
    public void test_(){
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
