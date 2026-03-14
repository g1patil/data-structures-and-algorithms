package graph;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CountPaths {

    private int count = 0;
    Map<String,Integer> cost;
    Map<Integer,Integer> pathMap = new TreeMap<>();

    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<Integer>> g = buildGraph(roads);
        dfs(g,0,n-1,0);
        return pathMap.keySet().stream().findFirst().get();

    }

    private void dfs(Map<Integer, List<Integer>> g, int source, int target,int min){
        if(source == target){
            pathMap.put(min,pathMap.getOrDefault(min,0) + 1);
            return;
        }
        if(!g.containsKey(source))
            return;
        for(int next : g.get(source)){
            dfs(g,next,target , min + getCost(source,next));
        }
    }

    private int getCost(int s,int t){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(":");
        sb.append(t);
        return this.cost.get(sb.toString());
    }

    private Map<Integer,List<Integer>> buildGraph(int[][] roads){
        Map<Integer,List<Integer>> result = new HashMap<>();
        this.cost = new HashMap<>();
        for(int[] road : roads){
            result.putIfAbsent(road[0],new ArrayList<>());
            result.get(road[0]).add(road[1]);

            StringBuilder sb = new StringBuilder();
            sb.append(road[0]);
            sb.append(":");
            sb.append(road[1]);
            this.cost.put(sb.toString(),road[2]);
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(
                countPaths(7,new int[][]{
                        {0,6,7},
                        {0,1,2},
                        {1,2,3},
                        {1,3,3},
                        {6,3,3},
                        {3,5,1},
                        {6,5,1},
                        {2,5,1},
                        {0,4,5},
                        {4,6,2},
                })
        );
    }
}
