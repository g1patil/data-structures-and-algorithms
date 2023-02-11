package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1656. Design an Ordered Stream
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class OrderedStream {

    private int size,pointer;
    private int[] values;
    private Map<Integer,String> map;

    public OrderedStream(int n) {
        size = n;
        pointer = 1;
        values = new int[n+1];
        map = new HashMap<>();
    }

    public List<String> insert(int idKey, String value) {
        values[idKey] = idKey;
        map.put(idKey,value);
        return getStreamValues();
    }

    private List<String> getStreamValues(){
        List<String> result = new ArrayList<>();
        if(values[pointer] == 0)
            return result;
        for(int i = pointer; i <= size ; i++) {
            if(map.containsKey(i)){
                result.add(map.get(i));
            } else {
                pointer = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        OrderedStream od = new OrderedStream(5);
        od.insert(3,"ccccc");
        od.insert(1,"aaaaa");
        od.insert(2,"bbbbb");
        od.insert(5,"eeeee");

        System.out.println(
                od.insert(4,"ddddd")
        );
    }
}
