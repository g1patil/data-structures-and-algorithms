package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

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
        Arrays.sort(intervals , Comparator.comparingInt(a-> a[0]));

        /* add them to list/ Iterate over each next pair, if overlap then merge , or continue*/
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] ints : intervals)
            list.add(ints);

        for (int i = 0; i < list.size() - 1 ; i++) {
            if (list.get(i)[1] >= list.get(i+1)[0]){
                int[] _ints = new int[]{
                        Math.min(list.get(i)[0] , list.get(i+1)[0]) ,
                        Math.max(list.get(i)[1] , list.get(i+1)[1])
                };
                list.remove(i);
                list.remove(i);
                list.add( i ,_ints);
                i--;
            }
        }

        /* convert the list back to array*/
        int[][] _interval = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            _interval[i] = list.get(i);
        }
        return _interval ;
    }

    @Test
    public void test_(){
        int[][] ints = new int[][]{
                new int[]{1,3},
                new int[]{2,6},
                new int[]{8,10},
                new int[]{15,18},
        };

        System.out.println(merge(ints));
    }

    @Test
    public void test_2(){
        int[][] ints = new int[][]{
                new int[]{1,4},
                new int[]{2,3}
        };

        System.out.println(merge(ints));
    }
}
