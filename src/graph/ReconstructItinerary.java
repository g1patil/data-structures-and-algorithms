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
 *
 * */
@Quality(value = Stage.FAILING, details = "somehow works in local but does not work in the LC")
@Platform(Site.LEETCODE)
public class ReconstructItinerary {

    Map<String , FlightNode> flightNodeMap = new HashMap<>();
    List<List<String>> tickets = new ArrayList<>();
    Set<String> visited = new HashSet<>();
    List<String> tour = new LinkedList<>();

    /**
     * Returns the next unvisited node from the source node.
     * @param source node
     * @return list of nodes that we can visit from source
     * */
    public List<String> getNextNode(String source){
        List<String> nextFlights = new ArrayList<>();

        for (int i : flightNodeMap.get(source).indexes){
            List<String> _ticket = tickets.get(i);
            String other = _ticket.get(0) == source ? _ticket.get(1): _ticket.get(0);
            if (!visited.contains(source+other)){
                nextFlights.add(other);
            }
        }

        return nextFlights;
    }

    /**
     * Builds the Graph and returns the starting node
     * @param tickets list of list of nodes or flight tickets
     * */
    public String buildGraphAndGetStartNode(List<List<String>> tickets){
        this.tickets = tickets;

        for (int i = 0 ; i < tickets.size() ; i ++){
            List<String> flights = tickets.get(i);
            String s = flights.get(0);
            String d = flights.get(1);

            if (!flightNodeMap.containsKey(s)){
                List<Integer> integerList = new ArrayList<>();
                integerList.add(i);
                flightNodeMap.put( s , new FlightNode(s , integerList , 1));
            } else {
                flightNodeMap.get(s).indexes.add(i);
                flightNodeMap.get(s).outDegree ++;
            }

            if (!flightNodeMap.containsKey(d)){
                flightNodeMap.put( d , new FlightNode(d , new ArrayList() , -1));
            } else {
                flightNodeMap.get(d).outDegree --;
            }

        }

        return flightNodeMap.keySet().stream().filter( k-> flightNodeMap.get(k).outDegree == 1).findFirst().get();

    }

    /**
     * Build the flight ticket path from given list of tickets
     * */
    public List<String> findItinerary(List<List<String>> tickets) {
        String startNode = buildGraphAndGetStartNode(tickets);
        tour.add(startNode);
        dfs(startNode);
        return tour;
    }

    /**
     * Runs the DFS on graph from stating node
     * @param node start node
     * */
    public void dfs(String node){
        for (String next : getNextNode(node)){
            if (!visited.contains(node + next)){tour.add(next);}
            visited.add(node+next);
            dfs(next);
        }
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

class FlightNode {
    String source;
    List<Integer> indexes;
    int outDegree;

    FlightNode(String _source , List _indexes , int _outDegree){
        this.source = _source ;this.indexes = _indexes;this.outDegree = _outDegree;
    }
}
