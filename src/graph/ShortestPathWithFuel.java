package graph;

import org.junit.jupiter.api.Test;

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

    private int getShortestPath(){
        return -1;
    }

    @Test
    public void test(){

    }
}

class CityRoute {
    int distance;
    int fuelNeed;
    String source;
    String destination;

    public CityRoute(int distance, int fuelNeed, String source, String destination) {
        this.distance = distance;
        this.fuelNeed = fuelNeed;
        this.source = source;
        this.destination = destination;
    }
}
