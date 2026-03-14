package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @author g1patil
 * 1762. Buildings With an Ocean View
 */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class BuildingsWithOceanView {

    LinkedList<Integer> list = new LinkedList();

    public int[] findBuildings(int[] heights) {
        int max = Integer.MIN_VALUE;

        for (int i = heights.length-1; i >=0  ; i--) {
            if (heights[i] > max){
                list.addFirst(i);
                max = Math.max( max , heights[i]);
            }
        }

        int [] result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.removeFirst();
        }

        return result;
    }

    @Test
    public void test_(){
        findBuildings(new int[]{4,2,3,1});
    }
}
