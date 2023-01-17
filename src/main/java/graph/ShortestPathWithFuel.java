package graph;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Google Maps recently launched the fucntionality to get the\
 * route to the destination keeping in mind the fuel efficincy.
 * Regular Shortest path algo (Dijkstra) are usally implemented using the distance
 * between the nodes.
 * This is the extension to the shortest path algo, with some added comlexity.
 * We will add fuel complexity. You need to travel to the destination keeping in
 * mind that you do not run out of the fuel. We will assign some nodes as the fuel station.
 * Not every city will have the fuel station. You might or might not want to fill the tank
 * because you might or you might not need the fuel. But fill enough so that you reach the detination.
 *
 * */

public class ShortestPathWithFuel {

    Map<String,Integer> paths = new HashMap<>();
    Set<String> fuelStations = new HashSet<>();

    {
        fuelStations.add("C");
    }


    private int getShortestPath(Map<String, List<CityRoute>> graph , String source , String destination, final int fuelCapacity){
        getShortestPathHelper(graph , source , destination , fuelCapacity ,0 );
        return paths.get(destination);
    }

    private void getShortestPathHelper(Map<String, List<CityRoute>> graph , String source , String dest , int currentFuel , int time){
        if (currentFuel < 0)
            return;

        if (!paths.containsKey(source)){
            paths.put(source , time);
        } else if( paths.containsKey(source) && paths.get(source) > time) paths.put(source , time);

        if (!graph.containsKey(source))
            return;

        for (CityRoute nextSource : graph.get(source)){
            int fuelCost = nextSource.fuelNeed;
            int etaToDestination = nextSource.etaToDestination;
            boolean fuelStation = fuelStations.contains(nextSource.destination);
            int fuelTime = fuelStation ? nextSource.refuelTime : 0 ;


            if (fuelStation){
                getShortestPathHelper(
                        graph , nextSource.destination , dest ,
                        10 , time + etaToDestination + fuelTime
                );
                getShortestPathHelper(
                        graph , nextSource.destination , dest ,
                        currentFuel - fuelCost , time + etaToDestination
                );
            } else {
                if (currentFuel - fuelCost > 0 ){
                    getShortestPathHelper(
                            graph , nextSource.destination , dest ,
                            currentFuel - fuelCost , time + etaToDestination
                    );
                }
            }
        }
    }

    @Test
    public void test(){
        Map<String, List<CityRoute>> graph = new HashMap<>();

        List<CityRoute> forA = new ArrayList<>();
        forA.add(new CityRoute(5 , 2 , 2,"B"));
        forA.add(new CityRoute(3 , 2 , 2,"C"));

        List<CityRoute> forB = new ArrayList<>();
        forB.add(new CityRoute(4 , 3 , 2,"D"));

        List<CityRoute> forC = new ArrayList<>();
        forC.add(new CityRoute(4 , 3 , 1, "D"));

        graph.put("A", forA);
        graph.put("B", forB);
        graph.put("C", forC);

        getShortestPath(graph , "A","D",5);
        System.out.println(paths);


    }
}

class CityRoute {
    int etaToDestination;
    int fuelNeed;
    int refuelTime;
    String destination;

    public CityRoute(int etaToDestination, int fuelNeed, int refuelTime , String destination) {
        this.etaToDestination = etaToDestination;
        this.fuelNeed = fuelNeed;
        this.destination = destination;
        this.refuelTime = refuelTime;
    }
}
