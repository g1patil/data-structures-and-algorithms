package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author g1patil
 * 973. K Closest Points to Origin
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class KClosestPointsOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PointWrapper> queue = new PriorityQueue<>(Comparator.comparingDouble(o-> o.distance));

        for (int[] ints : points){
            double d = Math.sqrt( Math.pow(ints[0], 2) + Math.pow(ints[1], 2));
            queue.add(new PointWrapper(d , ints));
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().point;
        }

        return result;

    }


    @Test
    public void test_(){
        int[][] ints = new int[][]{
                new int[]{3,3},
                new int[]{5,-1},
                new int[]{-2,4}
        };
        kClosest(ints , 2 );
    }
}

class PointWrapper {
    public double distance;
    public int[] point;
    public PointWrapper(double _d , int[] _i){ distance = _d ; point = _i;}
}
