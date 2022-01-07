package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author g1patil
 * 146. LRU Cache
 */
@Quality(value = Stage.FAILING , details = "s**t LC. Passed the test that failed on the platform online. Passes 14/22 . No idea why Lc is behaving like this.")
@Platform(Site.LEETCODE)
public class LRUCache {

    int CAPACITY ;
    int SIZE = 0 ;
    Map<Integer , Integer> CACHE = new HashMap<>();
    LinkedList<Integer> queue = new LinkedList<>();

    public LRUCache(int capacity) {
        CAPACITY = capacity;
    }

    public int get(int key) {
        if (CACHE.containsKey(key)){
            queue.removeFirstOccurrence(key);
            queue.addLast(key);
        }
        return CACHE.getOrDefault(key , -1);
    }

    public Object put(int key, int value) {

        if (CACHE.containsKey(key)){
            queue.removeFirstOccurrence(key);
            queue.addLast(key);
            CACHE.put(key , value);
            return null;
        }
        if (SIZE == CAPACITY && !CACHE.containsKey(key)){
            CACHE.remove(queue.poll());
            SIZE --;
        }

        queue.addLast(key);
        CACHE.put(key , value);
        SIZE ++;
        return null;
    }

    public static void main(String[] args) {

            LRUCache lruCache = new LRUCache(10);
            lruCache.parser();

    }

    /**
     * Wrote one small parser for input that failed on the LC
     * */
    public void parser(){

        String[] actions = new String[]{"put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"};
        int[][] ints = new int[][]{
                new int[]{10,13},new int[]{3,17},new int[]{6,11},new int[]{10,5},new int[]{9,10},new int[]{13},new int[]{2,19},new int[]{2},new int[]{3},new int[]{5,25},new int[]{8},new int[]{9,22},new int[]{5,5},new int[]{1,30},new int[]{11},new int[]{9,12},new int[]{7},new int[]{5},new int[]{8},new int[]{9},new int[]{4,30},new int[]{9,3},new int[]{9},new int[]{10},new int[]{10},new int[]{6,14},new int[]{3,1},new int[]{3},new int[]{10,11},new int[]{8},new int[]{2,14},new int[]{1},new int[]{5},new int[]{4},new int[]{11,4},new int[]{12,24},new int[]{5,18},new int[]{13},new int[]{7,23},new int[]{8},new int[]{12},new int[]{3,27},new int[]{2,12},new int[]{5},new int[]{2,9},new int[]{13,4},new int[]{8,18},new int[]{1,7},new int[]{6},new int[]{9,29},new int[]{8,21},new int[]{5},new int[]{6,30},new int[]{1,12},new int[]{10},new int[]{4,15},new int[]{7,22},new int[]{11,26},new int[]{8,17},new int[]{9,29},new int[]{5},new int[]{3,4},new int[]{11,30},new int[]{12},new int[]{4,29},new int[]{3},new int[]{9},new int[]{6},new int[]{3,4},new int[]{1},new int[]{10},new int[]{3,29},new int[]{10,28},new int[]{1,20},new int[]{11,13},new int[]{3},new int[]{3,12},new int[]{3,8},new int[]{10,9},new int[]{3,26},new int[]{8},new int[]{7},new int[]{5},new int[]{13,17},new int[]{2,27},new int[]{11,15},new int[]{12},new int[]{9,19},new int[]{2,15},new int[]{3,16},new int[]{1},new int[]{12,17},new int[]{9,1},new int[]{6,19},new int[]{4},new int[]{5},new int[]{5},new int[]{8,1},new int[]{11,7},new int[]{5,2},new int[]{9,28},new int[]{1},new int[]{2,2},new int[]{7,4},new int[]{4,22},new int[]{7,24},new int[]{9,26},new int[]{13,28},new int[]{11,26}
        };

        for (int i = 0 ; i < actions.length; i ++){
            if (actions[i].equals("put")){
                System.out.print(this.put(ints[i][0], ints[i][1]) + ",");
            } else System.out.print(get(ints[i][0]) + ",");
        }

    }
}
