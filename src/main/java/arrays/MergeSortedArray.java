package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

/**
 * @author g1patil
 * 88. Merge Sorted Array
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m -1 , p2 = n -1 , p = nums1.length - 1 ;

        for(int i = m + n - 1 ; i >= 0 && p2 >= 0 ; i--){

            if(p1 >=0 && nums1[p1]> nums2[p2]){
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
    }

    @Test
    public void test_(){
        int[] one = new int[]{4,5,6,0,0,0};
        int[] two = new int[]{1,2,3};
        merge(one , 3 , two , 3);
        ArrayUtility.print(one);
    }
}
