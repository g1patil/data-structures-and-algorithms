package searching;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 278. First Bad Version
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FirstBadRevision {

    int[] ints = new int[]{0,0,0,0,0,1,1,1,1};

    public int firstBadVersion(int n) {
        int low = 0 , high = ints.length -1 ;

        while (low < high){
            int mid = low + (high - low)/2;
            if (ints[mid] == 1) {
                high = mid;
            } else low = mid + 1;
        }
        return low;
    }

    @Test
    public void test(){
        System.out.println(firstBadVersion(ints.length));
    }
}
