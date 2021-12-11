package codeforces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Kotlin Heroes ep 1
 * H. Longest Saw
 *
 * https://codeforces.com/problemset/problem/1170/H
 *
 * */
public class LongestSaw {

    List<Integer> integerList = new ArrayList<>();
    List<Integer> finalList = new LinkedList<>();

    private int getLargest(final int i){
        if ( integerList.isEmpty())
            return -1;
        int l =  integerList.get( integerList.size() - 1 );
        if ( l < i  || l == i )
            return -1;
        integerList.remove( integerList.size() - 1 );
        return l ;
    }

    private int getSmallest(final int i ){
        if ( integerList.isEmpty())
            return -1;
        int s =  integerList.get( 0 );
        if ( s > i ||  s == i )
            return -1;
        integerList.remove(0 );
        return s ;
    }

    private void buildSaw(){
        int POINTER = Integer.MIN_VALUE;
        while ( POINTER != -1 ){
            POINTER = getLargest(POINTER);
            if ( POINTER != -1 )
                finalList.add( POINTER );
            POINTER = getSmallest( POINTER );
            if ( POINTER != -1 )
                finalList.add( POINTER );
        }

        if ( !integerList.isEmpty()){
            if ( integerList.get(0) < finalList.get(0))
                finalList.add( 0 , integerList.get(0));
        }
    }

    @Test
    public void test(){
        this.integerList.add(1);
        this.integerList.add(2);
        this.integerList.add(3);
        this.integerList.add(4);
        this.integerList.add(5);
        this.integerList.add(6);
        this.integerList.add(7);
        this.integerList.add(8);
        this.integerList.add(9);
        this.integerList.add(10);

        this.buildSaw();
        System.out.println( finalList );
    }

    @Test
    public void test2(){
        this.integerList.add(100);
        this.integerList.add(100);
        this.integerList.add(100);

        this.buildSaw();
        System.out.println( finalList );
    }

    @Test
    public void test3(){
        this.integerList.add(1);
        this.integerList.add(2);
        this.integerList.add(2);
        this.integerList.add(2);
        this.integerList.add(2);
        this.integerList.add(2);
        this.integerList.add(3);

        this.buildSaw();
        System.out.println( finalList );
    }

    @Test
    // TODO need to build some robust test cases fot this.
    public void test4(){

    }
}
