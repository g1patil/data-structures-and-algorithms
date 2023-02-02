package arrays;

import annotation.Platform;
import annotation.Site;
import org.junit.Test;

import java.util.*;

@Platform(Site.LEETCODE)
public class LeastNumberOfUniqueIntegers {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> maps = new HashMap<>();
        Map<Integer, LinkedList<Integer>> freqMap = new HashMap<>();
        int totalUnique = getUniqueCount(arr);

        for(int i : arr){
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> es : maps.entrySet()){
            freqMap.putIfAbsent(es.getValue(),new LinkedList<>());
            freqMap.get(es.getValue()).add(es.getKey());
        }
        Set<Integer> set = new HashSet<>(maps.keySet());

        for (int i = 1; i <= k; i++) {

        }

        for(int i : freqMap.keySet()){
            LinkedList<Integer> li = freqMap.get(i);
            while (k > 0 && !li.isEmpty()){
                int num = li.remove();
                int f = maps.get(num);
                if (f == 1){
                    maps.remove(num);
                } else maps.put(num , f-1);
                k--;
            }
        }

        return maps.keySet().size();
    }

    @Test
    public void test(){
        System.out.println(
                findLeastNumOfUniqueInts(
                        new int[]{2,1,1,3,3,3},3
                )
        );
    }

    private int getUniqueCount(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i : arr) set.add(i);
        return set.size();
    }
}
