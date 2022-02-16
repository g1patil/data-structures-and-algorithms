package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 268. Missing Number
 */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : nums){
            min = Math.min(min , i);
            max = Math.max(max , i);
        }

        if(min!=0)
            return 0;
        int sum = 0 ;
        for(int i = min ; i <=max ; i++)
            sum+=i;

        for(int i : nums){
            sum-=i;
        }

        return sum== 0 ? max+1 : sum;
    }
}
