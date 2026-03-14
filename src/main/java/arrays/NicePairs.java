package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814. Count Nice Pairs in an Array
 *  a + rev(b) = rev(a) + b
 *  => a - rev(a) = b - rev(b)
 *  Count the frequency of number - number_reverse
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class NicePairs {

    public int countNicePairs(int[] nums) {
        Map<Long,Long> freq = new HashMap<>();
        long result = 0;
        for(int i : nums){
            long diff = i - getReverse(i);
            long count = freq.getOrDefault(diff , 0L);
            freq.put(diff, count+1);
            result +=count;
        }
        return (int) result;
    }

    private long getReverse(int num){
        long result = 0;
        while(num > 0){
            int digit = num % 10;
            result = result*10 + digit;
            num = num/10;
        }
        return result;
    }
}
