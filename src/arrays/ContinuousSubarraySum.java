package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

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
        Map<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            runningSum%=k;

            Integer prev = map.get(runningSum);

            if (prev != null){
                if ( i - prev > 1)
                    return true;
            } else map.put(runningSum , i );
        }
        return false;
    }
}
