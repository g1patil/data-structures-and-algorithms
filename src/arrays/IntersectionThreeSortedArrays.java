package arrays;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1213. Intersection of Three Sorted Arrays
 * */
@Platform(Site.LEETCODE)
public class IntersectionThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int p1 = 0 , p2 = 0 , p3 = 0;
        int v1 ,v2 , v3 ;
        int max = 0 ;

        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length){
            v1 = arr1[p1];
            v2 = arr2[p2];
            v3 = arr3[p3];

            if (v1 == v2 && v1 == v3){
                result.add(v1);
                p1++;
                p2++;
                p3++;
            }

            max = Math.max(arr1[p1] , Math.max(arr2[p2],arr3[p3]));

            while (arr1[p1] < max)
                p1++;
            while (arr2[p2] < max)
                p2++;
            while (arr3[p3] < max)
                p3++;

        }
        return result;
    }

    public List<Integer> arraysIntersectionMap(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i : arr1)
            map.put( i , map.getOrDefault(i , 0) + 1);
        for (int i : arr2)
            map.put( i , map.getOrDefault(i , 0) + 1);
        for (int i : arr3)
            map.put( i , map.getOrDefault(i , 0) + 1);

        map.keySet().forEach( k->{
            if (map.get(k) == 3)
                result.add(k);
        });
        return result;
    }

    @Test
    public void test(){
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{1,2,5,7,9};
        int[] arr3 = new int[]{1,3,4,5,8};

        System.out.println(arraysIntersectionMap(arr1,arr2,arr3));
    }
}
