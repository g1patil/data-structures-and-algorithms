package arrays;

import annotation.Platform;
import annotation.Site;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2215. Find the Difference of Two Arrays
 * */
@Platform(Site.LEETCODE)
public class FindtheDifferenceofTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap();
        Map<Integer,Integer> map2 = new HashMap();

        for(int i : nums1){
            map1.put(i , map1.getOrDefault(i,0) + 1);
        }
        for(int i : nums2){
            map2.put(i , map2.getOrDefault(i,0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        map1.keySet().stream().forEach(k->{
            if (map1.get(k)== 2)
                r1.add(k);
        });

        map2.keySet().stream().forEach(k->{
            if (map2.get(k)== 2)
                r2.add(k);
        });
        result.add(r1);
        result.add(r2);

        return result;
    }
}
