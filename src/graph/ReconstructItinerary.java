package graph;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author jivanpatil
 * 332. Reconstruct Itinerary
 * */
@Quality(value = Stage.TESTED)
@Platform(Site.LEETCODE)
public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> itinerary = new LinkedList<>();
        Map<String,PriorityQueue<String>> flights = buildflightMap(tickets);
        dfs("JFK" , itinerary , flights);
        return itinerary;
    }

    public void dfs(String port , LinkedList<String> itinerary , Map<String,PriorityQueue<String>> flights){
        PriorityQueue<String> nextFlights = flights.get(port);
        while ( nextFlights!=null && !nextFlights.isEmpty() ){
            dfs( nextFlights.poll() , itinerary , flights );
        }
        itinerary.addFirst(port);
    }


    private Map<String,PriorityQueue<String>> buildflightMap(List<List<String>> tickets){
        Map<String,PriorityQueue<String>> map = new HashMap<>();

        for(List<String> flight : tickets){
            map.putIfAbsent(flight.get(0) , new PriorityQueue<>());
            map.get(flight.get(0)).add(flight.get(1));
        }
        return map;
    }


    @Test
    public void test(){
        List<List<String>> tickets = new ArrayList<>();
        List<String> f1 = new ArrayList<>();
        f1.add("JFK");
        f1.add("SFO");
        List<String> f2 = new ArrayList<>();
        f2.add("JFK");
        f2.add("ATL");
        List<String> f3 = new ArrayList<>();
        f3.add("SFO");
        f3.add("ATL");
        List<String> f4 = new ArrayList<>();
        f4.add("ATL");
        f4.add("JFK");

        List<String> f5 = new ArrayList<>();
        f5.add("ATL");
        f5.add("SFO");

        tickets.add(f1);
        tickets.add(f2);
        tickets.add(f3);
        tickets.add(f4);
        tickets.add(f5);

        for (String s : findItinerary(tickets)) {
            System.out.print( s + "     ");
        }
    }

    @Test
    public void test2(){
        List<List<String>> tickets = new ArrayList<>();
        List<String> f1 = new ArrayList<>();
        f1.add("MUC");
        f1.add("LHR");
        List<String> f2 = new ArrayList<>();
        f2.add("JFK");
        f2.add("MUC");
        List<String> f3 = new ArrayList<>();
        f3.add("SFO");
        f3.add("SJC");
        List<String> f4 = new ArrayList<>();
        f4.add("LHR");
        f4.add("SFO");

        tickets.add(f1);
        tickets.add(f2);
        tickets.add(f3);
        tickets.add(f4);

        for (String s : findItinerary(tickets)) {
            System.out.print( s + "     ");
        }
    }
}
