package graph;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 * 787. Cheapest Flights Within K Stops
 */
@Platform(Site.LEETCODE)
@Quality(value = Stage.FAILING, details = "time limit exceeds")
public class CheapestFlightsWithinKStops {

    int cheapest = Integer.MAX_VALUE;
    Set<Integer> visited = new HashSet<>();
    private Map<Integer,List<Integer>> graph = new HashMap<>();
    private Map<String,Integer> ticketCost = new HashMap<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        buildGraph(flights);
        dfs(src , dst , k , 0 , 0);
        if(cheapest == Integer.MAX_VALUE){
            return -1;
        }
        return cheapest;
    }

    public List<Integer> getAdjacentNodes(Integer node){
        return graph.get(node);
    }

    public void buildGraph(int[][] _graph){
        for(int[] edge : _graph){
            ticketCost.put(Integer.toString(edge[0]) + Integer.toString(edge[1]) , edge[2]);
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
    }

    public void dfs(int _node , int _dest , int _k , int _currentDistance , int cost){
        if (_currentDistance <= _k  && _node == _dest ){
            cheapest = Math.min( cheapest , cost);
            return ;
        }

        if (_currentDistance > _k)
            return ;

        visited.add(_node);
        List<Integer> adjacentNodes = getAdjacentNodes(_node);
        if (adjacentNodes == null)
            return;

        for (Integer adjacent : adjacentNodes){
            dfs(adjacent , _dest , _k ,_currentDistance + 1  , cost + ticketCost.get(Integer.toString(_node) + Integer.toString(adjacent)));
        }

        return ;
    }




    /**
     * Smarter way to implement the Dijkstra from LC comment section
     * https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/1624971/Java-Solution
     * */
    public int findCheapestPriceFaster(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        Map<Integer, Integer> shortestPathsToNodes = new HashMap<>();
        prepareGraph(flights, graph);
        int minDist = Integer.MAX_VALUE;

        Queue<int[]> queue =  new LinkedList();
        queue.add(new int[]{src , 0 , k});

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            if (current[0] == dst){
                minDist = Math.min(minDist , current[1]);
                continue;
            }

            if (!graph.containsKey(current[0]) || current[2] < 0)
                continue;

            for (int[] next : graph.get(current[0])){
                if (!shortestPathsToNodes.containsKey(next[0]) || current[1] + next[1] < shortestPathsToNodes.get(next[0])){
                    shortestPathsToNodes.put(next[0], current[1] + next[1] );
                    queue.add(new int[]{next[0] , current[1] + next[1] , current[2] -1});
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    public void prepareGraph(int[][] flights, Map<Integer, List<int[]>> map){
        for(int[] trip : flights){
            map.putIfAbsent(trip[0], new ArrayList<>());
            map.get(trip[0]).add(new int[]{trip[1], trip[2]});
        }
    }

    @Test
    public void test_(){
        int[] e1 = new int[]{0,1,100};
        int[] e2 = new int[]{1,2,200};
        int[] e3 = new int[]{0,2,500};

        int[][] g = new int[][]{e1,e2,e3};

        System.out.println(findCheapestPrice(3 , g , 0  , 2 , 1));
    }

    @Test
    public void test_3(){
        int[] e1 = new int[]{0,1,1};
        int[] e2 = new int[]{0,2,2};
        int[] e3 = new int[]{0,3,0};
        int[] e4 = new int[]{1,4,2};
        int[] e5 = new int[]{2,4,1};
        int[] e6 = new int[]{3,4,1};

        int[][] g = new int[][]{e1,e2,e3,e4,e5,e6};

        System.out.println(findCheapestPrice(3 , g , 0  , 4 , 2));
    }

    @Test
    public void test_2(){
        int[] e1 = new int[]{4,1,1};
        int[] e2 = new int[]{1,2,3};
        int[] e3 = new int[]{0,3,2};
        int[] e4 = new int[]{0,4,10};
        int[] e5 = new int[]{3,1,1};
        int[] e6 = new int[]{1,4,3};

        int[][] g = new int[][]{e1,e2,e3 ,e4,e5,e6};

        System.out.println(findCheapestPriceFaster(5 , g , 0  , 2 , 3));
    }
}
