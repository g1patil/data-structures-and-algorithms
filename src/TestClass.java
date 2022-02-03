import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {



    class Point {
        int index;
        double dis ;

        Point(int i , double d){
            index = i ; dis = d;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.dis));

        for(int i = 0 ; i < points.length ; i ++){
            double d = Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);

            queue.add(new Point(i,d));
        }

        int[][] result = new int[k][2];

        int j = 0 ;

        while ( j < k){
            result[j] = points[queue.poll().index];
            j++;
        }

        return result ;

    }

}
