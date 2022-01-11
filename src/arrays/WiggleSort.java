package arrays;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author g1patil
 * 280. Wiggle Sort
 */
@Platform(Site.LEETCODE)
public class WiggleSort {

    public void wiggleSort(int[] nums) {
        if (nums.length == 1 || nums.length ==2)
            return;

        Arrays.sort(nums);

        int p1= 0;
        int p2 = nums.length -1 ;
        int i = 0 ;

        int[] _ints = new int[nums.length];

        while (p1 <= p2 && nums[p1] < nums[p2]){
            _ints[i] = nums[p1];
            p1++;
            i++;
            _ints[i] = nums[p2];
            p2--;
            i++;
        }

        if (i < nums.length)

        for (int j : _ints)
            System.out.println(j);


    }
    @Test
    public void test_(){
        wiggleSort(new int[]{6,6,5,6,3,8});
    }

}
