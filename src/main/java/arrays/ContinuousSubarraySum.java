package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 * 523. Continuous Subarray Sum
 *
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(){{put(0,-1);}};
        for(int i = 0 ; i < nums.length ; i ++){
            sum= (sum+nums[i]) % k;
            Integer prev = map.get(sum);

            if (prev != null){
                if ( i - prev > 1)
                    return true;
            } else map.put(sum , i );
        }
        return false;
    }

    @Test
    public void test_(){
        System.out.println(checkSubarraySum(new int[]{1,2,12},6));
    }
}
