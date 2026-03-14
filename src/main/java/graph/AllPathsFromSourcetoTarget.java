package graph;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 797. All Paths From Source to Target
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class AllPathsFromSourcetoTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        Map<Integer, List<Integer>> graphMap = buildGraph(graph);
        List<String> result = new LinkedList<>();
        dfs("", 0, graph.length-1, result, graphMap);
        return convertToResult(result);
    }


    private void dfs(String path, int source, int target, List<String> result, Map<Integer, List<Integer>> graph){
        if(source == target){
            path = path+" "+source;
            result.add(path);
            return;
        }

        path = path+" "+source;
        for(int next : graph.get(source)) {
            dfs(path, next, target, result, graph);
        }
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] graph){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < graph.length; i++) {
            map.put(i, new ArrayList<>());
            for(int j = 0; j < graph[i].length; j++) {
                map.get(i).add(graph[i][j]);
            }
        }
        return map;
    }

    private List<List<Integer>> convertToResult(List<String> result){
        List<List<Integer>> list = new ArrayList<>();
        result.stream().forEach(
                r -> {
                    List<Integer> l = new ArrayList<>();
                    for(String c : r.split(" ")) {
                        if(!c.isBlank())
                            l.add(Integer.parseInt(c));
                    }
                    list.add(l);
                }
        );
        return list;
    }

    @Test
    public void test(){
        int[][] g = {
                {1, 2},
                {3},
                {3},
                {}
        };
        System.out.println(
                allPathsSourceTarget(g)
        );
    }
}
