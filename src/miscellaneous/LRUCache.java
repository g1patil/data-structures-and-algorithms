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


}
