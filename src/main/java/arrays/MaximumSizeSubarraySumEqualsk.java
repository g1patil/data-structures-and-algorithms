package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 * 325. Maximum Size Subarray Sum Equals k
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MaximumSizeSubarraySumEqualsk {

    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0 , result = 0 ;
        Map<Integer,Integer> map = new HashMap();

        for(int i = 0 ; i < nums.length ; i ++){
            sum+=nums[i];

            if (sum == k)
                result = i + 1 ;

            if(map.containsKey(sum-k)){
                result = Math.max( result , i  - map.get(sum-k));
            }
            if (!map.containsKey(sum))
                map.put(sum , i );
        }
        return result;
    }
}
