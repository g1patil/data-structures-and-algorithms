package graph;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 815. Bus Routes
 *
 * You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
 *
 * For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
 * You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target.
 * You can travel between bus stops by buses only.
 *
 * Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
 *
 * Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * Output: 2
 * Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 *
 * */
@Platform(Site.LEETCODE)
public class BusRoutes {

    private int[][] routes ;

    private int[] getNextRoute(final int node , List<Integer> exclude){
        for(int index = 0 ; index < routes.length  ; index ++){
             if (Arrays.stream(routes[index]).anyMatch( a-> a == node)  && !exclude.contains(index) ){
                 exclude.add( index );
                 return routes[index];
             }
        }
        return null;
    }

    private int getRoutes(int source , int target , List<Integer> exclude){
        if ( source == target){
            return exclude.size();
        }

        int[] nextRoute = getNextRoute( source , exclude );

        if ( nextRoute == null )
            return -1 ;

        for ( int nextSource : nextRoute){
            if ( getRoutes( nextSource , target , exclude ) != -1){
                return exclude.size();
            }
        }
        return  -1 ;
    }

    @Test
    public void test(){
        this.routes = new int[][]{
                new int[]{ 2 , 5 , 7},
                new int[]{ 10 , 18 , 19},
                new int[]{ 1 , 5 , 0},
                new int[]{ 0 , 8 , 9}
        };

        System.out.println( getRoutes( 2 , 19  , new ArrayList<>()) );
    }


}
