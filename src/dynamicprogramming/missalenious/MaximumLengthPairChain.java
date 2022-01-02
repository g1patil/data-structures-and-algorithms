package dynamicprogramming.missalenious;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 * 646. Maximum Length of Pair Chain
 *
 * Sol : idea is to convert this to longest increasing sub sequence
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MaximumLengthPairChain {

    /**
     * Recursive approach. Limitation : time out
     * */
    public int findLongestChainHelper(int _start , int _index , int[][] pairs){
        if (_index >=pairs.length)
            return 0 ;

        if (pairs[_index][0] > _start){
            return Math.max(
                    1 + findLongestChainHelper(pairs[_index][1] , _index + 1 , pairs),
                    findLongestChainHelper(_start , _index + 1 , pairs)
            );
        }

        return findLongestChainHelper(_start , _index + 1 , pairs);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort( pairs , Comparator.comparingInt(o-> o[0]));
        return findLongestChainHelper(Integer.MIN_VALUE , 0 , pairs);
    }

    public int findLongestChainHelperDP(int _start , int _index , int[][] pairs){
        if (_index >=pairs.length)
            return 0 ;

        int[] dp = new int[pairs.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1 ;
        }

        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1 ;
            }
        }

        int result = 1 ;

        for (int i : dp)
            result = Math.max(result , i );

        return result;

    }

    @Test
    public void test_(){
        int[][] pairs = new int[][]{
                new int[]{-10,-8},
                new int[]{8,9},
                new int[]{-5,0},
                new int[]{6,10},
                new int[]{-6,-4},
                new int[]{1,7},
                new int[]{9,10},
                new int[]{-4,7}
        };

        System.out.println(findLongestChain(pairs));
    }
}
