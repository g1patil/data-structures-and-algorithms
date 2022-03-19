package miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 * 986. Interval List Intersections
 */
public class IntervalListIntersections {

    static final int limit = 100;
    public List<int[]> intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        boolean[] first = new boolean[limit];
        boolean[] second = new boolean[limit];

        init(firstList,first);
        init(secondList,second);

        int start = 0;

        while ( start <  100 ){
            while (start < 100 && ( first[start] != second[start] || (!first[start] && !second[start]) )){
                start++;
            }

            if (start < 100){
                int[] cal = calculate(first, second, start);
                int len = cal[0];
                result.add(new int[]{start, start + len});
                start = cal[1];
            }
        }
        return result;
    }

    public void init(int[][] lists, boolean[] flags){
        for(int[] list : lists){
            for (int i = list[0]; i <= list[1] ; i++) {
                flags[i] = true;
            }
        }
    }

    public int[] calculate(boolean[] first, boolean[] second , int start){
        int inc = - 1;
        while (start < 100 && first[start] && second[start]){
            inc++;
            start++;
        }
        return new int[]{inc , start };
    }

    @Test
    public void test_(){
        int[][] first = new int[][]{
                {0,2},
                {5,10}

        };

        int[][] second = new int[][]{
                {1,5}

        };

        System.out.println(intervalIntersection(first,second));
    }
}
