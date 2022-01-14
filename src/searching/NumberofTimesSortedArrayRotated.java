package searching;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 153. Find Minimum in Rotated Sorted Array
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class NumberofTimesSortedArrayRotated {

    /**
     * V1
     * */
    public int getIndexOfRotation(int[] ints){
        return binarySearchHelper(ints , 0 , ints.length - 1);
    }

    int result = 0 ;
    private int binarySearchHelper(int[] ints, int i, int j) {
        if (i > j || j >= ints.length || i < 0 )
            return result;

        int mid = (i + j )/2 ;

        if (mid > 0 && ints[mid] < ints[mid -1]){
            result = mid ;
            return result;
        }

        binarySearchHelper(ints , i , mid -1);
        binarySearchHelper(ints , mid + 1 , j);
        return result;
    }


    @Test
    public void test_(){
        System.out.println(getIndexOfRotation(new int[]{6,7,8,1}));
    }
}
