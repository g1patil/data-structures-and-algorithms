package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * 2032. Two Out of Three
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class TwoOutofThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] num_1 = new int[101];
        int[] num_2 = new int[101];
        int[] num_3 = new int[101];

        for(int i : nums1) num_1[i]++;
        for(int i : nums2) num_2[i]++;
        for(int i : nums3) num_3[i]++;

        List<Integer> li = new ArrayList<>();
        for(int i = 1 ; i <= 100;i++){
            int c1 = num_1[i] > 0 ? 1 : 0;
            int c2 = num_2[i] > 0 ? 1 : 0;
            int c3 = num_3[i] > 0 ? 1 : 0;

            if(c1+c2+c3 > 1 )
                li.add(i);
        }
        return li;
    }
}
