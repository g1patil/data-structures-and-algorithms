package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 * 1146. Snapshot Array
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SnapshotArray {

    Map<Integer,Map<Integer,Integer>> snapMap = new HashMap();
    Map<Integer,Integer> values ;
    int snap_id = 0 ;
    int size  ;

    public SnapshotArray(int length) {
        size = length;
        values = new HashMap();
    }

    public void set(int index, int val) {
        values.put(index,val);
    }

    public int snap() {
        snapMap.put(snap_id , values);
        values = new HashMap(values);
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        if ( !snapMap.get(snap_id).containsKey(index) )
            return 0;
        return (int) snapMap.get(snap_id).get(index);
    }

    @Test
    public void test_(){
    }
}
