package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.*;

/**
 * @author g1patil
 * 56. Merge Intervals
 */
@Quality(Stage.DOCUMENTED)
@Platform(Site.LEETCODE)
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        /* sort the intervals first*/
        Arrays.sort(intervals , Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> resultList = new LinkedList<>();

        for(int[] interval : intervals){
            if (resultList.isEmpty() || resultList.getLast()[1] < interval[0]){
                resultList.add(interval);
            } else resultList.getLast()[1] = Math.max( resultList.getLast()[1] , interval[1]);
        }
        return resultList.toArray(new int[resultList.size()][]);
    }

    @Test
    public void test_(){
        int[][] ints = {
                new int[]{1,3},
                new int[]{2,6},
                new int[]{8,10},
                new int[]{15,18},
        };

        ArrayUtility.print(merge(ints));
    }

    @Test
    public void test_2(){
        int[][] ints = {
                new int[]{1,4},
                new int[]{2,3}
        };

        System.out.println(merge(ints));
    }
}
