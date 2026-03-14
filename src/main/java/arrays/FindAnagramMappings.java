package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.*;

/**
 * 760. Find Anagram Mappings
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FindAnagramMappings {

    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Queue<Integer>> map = buildMap(nums2);
        int[] result = new int[nums1.length];
        int index = 0;

        for(int i : nums1){
            int _i = map.get(i).remove();
            result[index++] = _i;
        }
        return result;
    }

    private Map<Integer, Queue<Integer>> buildMap(int[] ints){
        Map<Integer, Queue<Integer>> result = new HashMap<>();

        for(int i = 0; i < ints.length; i++) {
            if(result.containsKey(ints[i])){
                result.get(ints[i]).add(i);
            } else {
                Queue<Integer> list = new LinkedList<>();
                list.add(i);
                result.put( ints[i],list);
            }
        }
        return result;
    }
}
