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
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : nums){
            if(i<=0)
                continue;
            min = Math.min(min , i);
            max = Math.max(max , i);
        }

        if(min!=1)
            return 1;
        int sum = 0 ;
        for(int i = min ; i <=max ; i++)
            sum+=i;

        for(int i : nums){
            if(i<=0)
                continue;
            sum-=i;
        }

        return sum== 0 ? max+1 : sum;
    }
}
