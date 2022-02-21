package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 41. First Missing Positive
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int[] missing = new int[nums.length + 1];

        for(int val : nums){
            if(val < missing.length && val >=0 )
                missing[val] = - 1;
        }

        int i = 1;

        for( ; i < missing.length ; i++){
            if(missing[i]!= -1)
                return i;
        }

        return i;
    }
}
