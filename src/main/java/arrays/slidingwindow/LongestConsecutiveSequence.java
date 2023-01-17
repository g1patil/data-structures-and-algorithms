package arrays.slidingwindow;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashMap;

/**
 * @author g1patil
 *
 * 128. Longest Consecutive Sequence
 * Reference : https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> lengthMap = new HashMap<>();
        int result = 0 ;

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];

            if (!lengthMap.containsKey(currentNumber)){

                int left = lengthMap.getOrDefault(currentNumber - 1, 0);
                int right = lengthMap.getOrDefault(currentNumber + 1, 0);

                int length = left + right + 1;

                result = Math.max(length , result);


                lengthMap.put(currentNumber , length);
                lengthMap.put( currentNumber - left , length);
                lengthMap.put( currentNumber + right , length);

            } else {
                continue;
            }

        }

        return result;
    }
}
