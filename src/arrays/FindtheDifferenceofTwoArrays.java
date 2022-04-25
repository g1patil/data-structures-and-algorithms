package arrays;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

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
            map1.put(i , 1);
        }
        for(int i : nums2){
            if (map1.containsKey(i))
                map1.put(i , map1.getOrDefault(i,0) + 1);
        }

        for(int i : nums2){
            map2.put(i ,  1);
        }
        for(int i : nums1){
            if (map2.containsKey(i))
                map2.put(i , map2.getOrDefault(i,0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        map1.keySet().stream().forEach(k->{
            if (map1.get(k)== 1)
                r1.add(k);
        });

        map2.keySet().stream().forEach(k->{
            if (map2.get(k)== 1)
                r2.add(k);
        });
        result.add(r1);
        result.add(r2);

        return result;
    }

    @Test
    public void test(){
        int[] a1 = new int[]{1,2,3};
        int[] a2 = new int[]{2,4,6};

        System.out.println(findDifference(a1,a2));
    }
}
