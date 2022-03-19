package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 * 986. Interval List Intersections
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> answerList = new ArrayList<>();
        int first = 0 , second = 0;

        while ( first < firstList.length && second < secondList.length){
            int low     = Math.max( firstList[first][0] , secondList[second][0]);
            int high    = Math.min( firstList[first][1] , secondList[second][1]);

            if (low<= high)
                answerList.add(new int[]{low , high});
            if (firstList[first][1] < secondList[second][1]){
                first++;
            } else second++;
        }
        return answerList.toArray(new int[answerList.size()][]);
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

        ArrayUtility.print(intervalIntersection(first,second));
    }
}
