package arrays;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 * 560. Subarray Sum Equals K
 */
@Platform(Site.LEETCODE)
public class SubarraySumEqualsK {

    // TLE time limit exceeds - not recommended
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    @Test
    public void test_(){
        System.out.println(subarraySum(new int[]{3,4,7,2,-3,1,4,2} , 7 ));
    }
}
