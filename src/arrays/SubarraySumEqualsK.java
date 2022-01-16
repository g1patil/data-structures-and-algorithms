package arrays;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 560. Subarray Sum Equals K
 */
@Platform(Site.LEETCODE)
public class SubarraySumEqualsK {

    // TLE time limit exceeds - not recommended
    public int subarraySum(int[] nums, int k) {
        int count = 0 ;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0 ;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k){
                    count ++;
                    continue;
                }
            }
        }

        return count;
    }

    @Test
    public void test_(){
        System.out.println(subarraySum(new int[]{1,1,1} , 2 ));
    }
}
