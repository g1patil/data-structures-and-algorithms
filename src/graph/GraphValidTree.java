package graph;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphValidTree {

    Map<Integer , Queue<Integer>> graph = new HashMap<>();
    Map<Integer , Integer> degreeMap = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {

        buildGraph(edges);
        return false;
    }

    private void buildGraph(int[][] edges) {

        for (int[] pair : edges){
            int source = pair[0];
            int destination = pair[1];

            Queue sourceQueue = graph.get(source);
            Queue destQueue = graph.get(source);

            if (sourceQueue == null){
                sourceQueue = new LinkedList();
            }

            if (destQueue == null){
                destQueue = new LinkedList();
            }

            sourceQueue.add(destination);
            destQueue.add(source);


        }
    }

    [],[1,2],[2,3],[1,3],[1,4]
    @Test
    public void test(){
        int[][] matrix = new int[][]{
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
        }
    }
}
