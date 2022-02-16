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
 * 219. Contains Duplicate II
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();

        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k)
                    return true;
                map.put(nums[i], i );
            } else{
                map.put(nums[i],i);
            }
        }
        return false;
    }

    @Test
    public void test_(){
        int[] ints = new int[]{1,2,3,1};
        System.out.println(containsNearbyDuplicate(ints , 3));
    }

    @Test
    public void test_2(){
        int[] ints = new int[]{1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(ints , 2));
    }
}
