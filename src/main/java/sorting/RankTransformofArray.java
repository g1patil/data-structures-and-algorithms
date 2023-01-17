package sorting;


import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. Rank Transform of an Array
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class RankTransformofArray {

    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0 , rank = 1; i < temp.length; i++) {
            if (!indexMap.containsKey(temp[i])){
                indexMap.put(temp[i], rank);
                rank++;
            }
        }

        int[] result = new int[temp.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = indexMap.get(arr[i]);
        }

        return result;
    }

    @Test
    public void test(){
        System.out.println(arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12}));
    }
}
