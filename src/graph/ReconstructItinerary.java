package graph;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author jivanpatil
 * 332. Reconstruct Itinerary
 * */
@Platform(Site.LEETCODE)
public class ReconstructItinerary {

    Map<String , FlightNode> flightNodeMap = new HashMap<>();
    List<List<String>> tickets = new ArrayList<>();
    Set<List<String>> visited = new HashSet<>();

    public String getNextNode(String source){
        for (int i = 0; i < flightNodeMap.get(source).indexes.size(); i++) {
            List<String> _ticket = tickets.get(i);
            if (!visited.contains(_ticket)){
                visited.add(_ticket);
                return _ticket.get(0) == source ? _ticket.get(1) : _ticket.get(0);
            }
        }

        return null;
    }

    public String buildDS(List<List<String>> tickets){
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
                List<Integer> integerList = new ArrayList<>();
                integerList.add(i);
                flightNodeMap.put( d , new FlightNode(d , integerList , -1));
            } else {
                flightNodeMap.get(d).indexes.add(i);
                flightNodeMap.get(d).outDegree --;
            }

        }

        return flightNodeMap.keySet().stream().filter( k-> flightNodeMap.get(k).outDegree == 1).findFirst().get();

    }
    public List<String> findItinerary(List<List<String>> tickets) {
        String startNode = buildDS(tickets);
        dfs(startNode);
        return null;
    }

    public void dfs(String node){

        while (node != null){
            String next = getNextNode(node);
            dfs(next);
        }

        System.out.println(node);
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

        findItinerary(tickets);
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
