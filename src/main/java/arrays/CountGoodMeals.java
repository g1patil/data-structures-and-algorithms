package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/*
 * 1711. Count Good Meals
 *
 * A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.

You can pick any two different foods to make a good meal.

Given an array of integers deliciousness where deliciousness[i] is the
* deliciousness of the ith item of food,
* return the number of different good meals you can make from this list modulo 109 + 7.

Note that items with different indices are considered different even if they have the same deliciousness value.



Example 1:

Input: deliciousness = [1,3,5,7,9]
Output: 4
Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.
Example 2:

Input: deliciousness = [1,1,1,3,3,3,7]
Output: 15
Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7) with 3 ways.


Constraints:

1 <= deliciousness.length <= 105
0 <= deliciousness[i] <= 220

 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class CountGoodMeals {

    /**
     *  Solution by https://leetcode.com/problems/count-good-meals/discuss/1015166/Java-HashMap-or-Faster-than-90-or-With-Comments
     *
     * */
    public int countPairs(int[] deliciousness) {
        long res = 0;
        long mod = (long)1e9 + 7;
        int max = 1 << 22;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int d : deliciousness) {
            // Optimization: Get highest bit if d > 0, because next possible power of 2 will be higher than that
            int target = (d > 0) ? Integer.highestOneBit(d) : 1;

            while(target < max) { // at most 31 iterations (because int will get negative if MSB bit is set)
                if(map.containsKey(target - d))
                    res = (res + map.get(target - d)) % mod;
                target <<= 1;
            }

            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        return (int)res;
    }

    @Test
    public void test(){
        Assertions.assertEquals( countPairs(new int[]{1,3,5,7,9}), 4);
    }
}
