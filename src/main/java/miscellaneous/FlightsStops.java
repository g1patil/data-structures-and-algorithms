package miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * There are cities connected by flights. Each flight starts from a city and arrives at another..
 * Now given all the cities and flights, your task is to find whether there is a route from a city to another within a fixed amount of stops. If there is no such route, output False, otherwise True
 * flights = [[0,1],[1,2]]
 * src=0, dest=2, stops=1
 * -> True
 *
 * */
public class FlightsStops {

    private static int result = Integer.MAX_VALUE;

    private Map<Integer, List<Integer>> buildFlightMap(int[][] flights){
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] flight : flights){
            map.putIfAbsent(flight[0],new LinkedList<>());
            map.get(flight[0]).add(flight[1]);
        }
        return map;
    }
    public boolean checkRoute(int[][] flights, int s, int d,int stops){
        Map<Integer, List<Integer>> map = buildFlightMap(flights);
        checkRoute(map,s,d,0);
        return result-1 == stops;
    }

    public void checkRoute(Map<Integer,List<Integer>> flights, int s, int d,int stops){
        if(s == d){
            result = Math.min(stops,result);
            return;
        }
        for(int newSource : flights.get(s)){
            checkRoute(flights,newSource,d,stops+1);
        }
    }

    @Test
    public void test(){
        System.out.println(
                checkRoute(
                        new int[][]{
                                new int[]{0,1},
                                new int[]{1,2},
                                new int[]{1,4},
                                new int[]{1,3},
                                new int[]{2,4},
                                new int[]{3,4},
                        },0,4,0
                )
        );
    }
}
