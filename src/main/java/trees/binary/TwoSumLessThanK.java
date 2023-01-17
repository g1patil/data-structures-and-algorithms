package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author g1patil
 * 1099. Two Sum Less Than K
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int result = -1 ;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k)
                continue;
            int j = getTwoSum( nums, k - i, i );
            if(j != -1)
                result = Math.max( i + j , result);

        }
        return result;
    }

    public int getTwoSum(int[] nums , int target , int i){
        int low = 0 , high = nums.length - 1 ;

        while(low < high){
            int mid = low + (high - low)/2;

            if (nums[mid] >= target){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high == 0 && high -1 >= i ? -1 : nums[high - 1];
    }

    @Test
    public void test_(){
        int[] ints = new int[]{803,468,292,154,924,424,197,277,753,86,984,144,105,450,287,265,655,404,407,794,513,976,241,272,84,
                503,65,654,805,413,362,907,297,473,113,567,646,607,806,674,424,753,870,574,765,170,603,696,513,58};
        System.out.println(twoSumLessThanK(ints , 300));
    }

    @Test
    public void test_2(){
        int[] ints = new int[]{10,20,30};
        System.out.println(twoSumLessThanK(ints , 15));
    }
}
