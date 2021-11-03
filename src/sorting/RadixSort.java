package sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Implement the RedixSort using the java collections framework
 * TODO finish the rest of the code
 * */
public class RadixSort {

    @Test
    public void test(){
        int some = 10 ;
        List<Integer> l = new ArrayList();

        l.add( 110 );
        l.add( 214 );
        l.add( 117 );
        l.add( 111 );
        l.add( 116 );
        l.add( 113 );

        l.sort(Comparator.comparingInt(c -> c % 10));

        System.out.println( l );
    }
}
