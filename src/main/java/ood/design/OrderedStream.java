package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. Design an Ordered Stream
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class OrderedStream {

    private String[] values;
    private int size , pointer;

    public OrderedStream(int n) {
        size = n;
        values = new String[n+1];
        pointer = 1;
    }

    public List<String> insert(int idKey, String value) {
        values[idKey] = value;
        return getStreamValues();
    }

    private List<String> getStreamValues(){
        List<String> result = new ArrayList<>();
        while( pointer <= size && values[pointer] != null){
            result.add(values[pointer++]);
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
