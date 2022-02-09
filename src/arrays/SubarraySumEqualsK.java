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


    public int subarraySum(int[] nums, int k) {
        int sum = 0 , result = 0 ;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for(int a : nums){
            sum+=a;
            if(map.containsKey(sum-k)){
                result+=map.get(sum-k);
            }
            map.put(sum , map.getOrDefault(sum , 0) + 1 );
        }
        return result;
    }


    public int subarraySumPractice(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0 , result = 0;

        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];

            //value generating block
            if (map.containsKey(sum  - k)){
                result+=map.get(sum - k );
            }

            map.put(sum , map.getOrDefault(sum  , 0) + 1);
        }

        return result;
    }

    @Test
    public void test_(){
        System.out.println(subarraySum(new int[]{3,4,7,2,-3,1,4,2} , 7 ));
    }
}
