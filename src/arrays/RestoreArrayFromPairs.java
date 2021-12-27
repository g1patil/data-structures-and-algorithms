package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;
import java.util.*;

/**
 * @author g1patil
 *
 * 1743. Restore the Array From Adjacent Pairs
 *
 * Graph trick for DFS : When getting the next pairs, use the queue ,
 * So that next time when we come back to the same vertex, queue will be empty.
 * Queue allow the concurrent traversal while removal also.
 */
@Platform(Site.LEETCODE)
@Quality(value = Stage.DOCUMENTED , details = "passes all the test case")
public class RestoreArrayFromPairs {

    Map<Integer , List> integerListMap = new HashMap<>();
    Set<Integer> integerSet = new HashSet<>();


    public int getAdjacent(int number, int[][] adjacentPairs){

       List<Integer> integers =  integerListMap.get(number);
        for (Integer integer : integers) {
            int[] pair = adjacentPairs[integer];
            if (!integerSet.contains(pair[0]))
                return pair[0];
            if (!integerSet.contains(pair[1]))
                return pair[1];
        }
        return 0;
    }

    /**
     * Add the position (index) of the element. This index is the position
     * where pairs are present. Also returns the first of last element
     * in the pairs.
     * @param adjacentPairs adjacent pairs
     * */
    public int initializePosition(int[][] adjacentPairs){
        for (int i = 0; i < adjacentPairs.length; i++) {

            if (integerListMap.containsKey(adjacentPairs[i][0])){
                integerListMap.get(adjacentPairs[i][0]).add(i);
            } else {
                List<Integer> list = new ArrayList();
                list.add(i);
                integerListMap.put(adjacentPairs[i][0] , list );
            }

            if (integerListMap.containsKey(adjacentPairs[i][1])){
                integerListMap.get(adjacentPairs[i][1]).add(i);
            } else {
                List<Integer> list = new ArrayList();
                list.add(i);
                integerListMap.put(adjacentPairs[i][1] , list );
            }

        }

        return integerListMap.keySet().stream().filter(k-> integerListMap.get(k).size() == 1).findFirst().get();

    }

    /**
     * Restores the array from adjacent pairs.
     * @param adjacentPairs adjacent pair of numbers
     * @return returns the final array.
     * */
    public int[] restoreArray(int[][] adjacentPairs) {
        List<Integer> integerList = new ArrayList<>();

        int firstElement = initializePosition(adjacentPairs);
        integerList.add(firstElement);
        integerSet.add(firstElement);

        for (int i = 0 ; i < adjacentPairs.length ; i ++){
            int next = getAdjacent(firstElement ,adjacentPairs);
            integerList.add(next);
            integerSet.add(next);
            firstElement = next;
        }

        int[] result = new int[integerList.size()];
        int index = 0;
        for (Integer i : integerList){
            result[index] = i ;
            index++;
        }

        return result;
    }

    @Test
    public void test_(){
        int[][] ints = new int[][]{
                new int[]{2,1},
                new int[]{3,4},
                new int[]{3,2}
        };
        System.out.println(restoreArray(ints));
    }
}
