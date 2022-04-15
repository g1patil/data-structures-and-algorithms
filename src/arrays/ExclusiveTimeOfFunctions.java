package arrays;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author g1patil
 */
@Platform(Site.LEETCODE)
public class ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        return null;
    }

    @Test
    public void test_(){
        List<String> l1= new ArrayList<>();
        List<String> l2= new ArrayList<>();
        List<String> l3= new ArrayList<>();

        l1.add("aaa");

        l1.add("55");
        l1.add("10");

        l2.add("aa");
        l2.add("555");
        l2.add("15");

        l3.add("a");
        l3.add("5");
        l3.add("7");

        List<List<String>> mainlist = new ArrayList<>();
        mainlist.add(l1);
        mainlist.add(l2);
        mainlist.add(l3);

        int param = 1 ;
        Collections.sort(mainlist, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(param).compareTo(o2.get(param));
            }
        });
        System.out.println(mainlist);
    }
}
