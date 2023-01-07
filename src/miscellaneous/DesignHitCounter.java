package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author g1patil
 * 362. Design Hit Counter
 */
@Quality(value = Stage.DOCUMENTED, details = "passed all the test cased")
@Platform(Site.LEETCODE)
public class DesignHitCounter {

    /* the main idea is to use the dictionary DS , since at same second there might be more hits*/
    private static Map<Integer , Integer> hitMap ;

    public DesignHitCounter() {
        hitMap = new ConcurrentHashMap<>();
    }

    /**
     * Registers the hit on the second. If second is already present then
     * increment the counter.
     * @param timestamp time in sec for hit.
     * */
    public void hit(int timestamp) {
        if (timestamp > 0){
            if (!hitMap.containsKey(timestamp)){
                hitMap.put( timestamp , 1);
            } else hitMap.put( timestamp , hitMap.get(timestamp) + 1 );
        }
    }

    /**
     * Return the count of all the hits which are registered in last 300 to timestamp
     * @param timestamp time stamp
     * @return sum of all counts
     * */
    public int getHits(int timestamp) {
        int multiple = 0;
        if (timestamp > 300){
            multiple = timestamp - 300;
        }
        int finalMultiple = multiple;
        List<Integer> integerList = hitMap.keySet().stream()
                .filter(k-> (k > finalMultiple)  && k <= timestamp)
                .collect(Collectors.toList());

        int result = 0;

        for (int k : integerList)
            result+=hitMap.get(k);
        return result;
    }

    public static void main(String[] args) {
        DesignHitCounter hitCounter = new DesignHitCounter();

        hitCounter.hit(2);
        hitCounter.hit(3);
        hitCounter.hit(4);
        hitCounter.hit(501);

        System.out.println(hitCounter.getHits(600));

    }
}
