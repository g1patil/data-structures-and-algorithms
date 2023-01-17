import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.*;

/**
 * 349. Intersection of Two Arrays
 * */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums1) set.add(i);
        List<Integer> result = new ArrayList<>();

        for(int i : nums2)
            if(set.contains(i))
                result.add(i);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
