package graph;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 *
 * Print the children which are k distance from the given node
 */
@Platform(Site.RANDOM)
public class NodeKDistance {

    Set<Integer> visited = new HashSet<>();
    LinkedHashSet<Integer> result = new LinkedHashSet<>();
    private Map<Integer , List<Integer>> graph = new HashMap<>();

    public List<Integer> getAdjacentNodes(Integer node){
        return graph.get(node);
    }

    public void buildGraph(int[][] _graph){
        for(int[] edge : _graph){
            int source = edge[0];
            int destination = edge[1];

            List<Integer> adjacentNodesSource = graph.get(source);

            if (adjacentNodesSource == null){
                adjacentNodesSource = new ArrayList<>();
            }

            adjacentNodesSource.add(destination);
            graph.put(source , adjacentNodesSource);
        }
    }

    public LinkedHashSet<Integer> getKDistanceNodes(int[][] _graph , int node , int k){
        buildGraph(_graph);
        return dfs(node , 2 , 0);
    }

    public LinkedHashSet<Integer> dfs(int _node , int _k , int _currentDistance){

        if (_currentDistance > _k)
            return result;

        if (_k == _currentDistance ){
            result.add(_node);
            return result;
        }

        visited.add(_node);

        for (Integer adjacent : getAdjacentNodes(_node)){
            dfs(adjacent , _k ,_currentDistance +1 );
        }

        return result;
    }

    @Test
    public void two(){
        int[] v1 = {0,1};
        int[] v2 = {1,3};
        int[] v3 = {0,5};

        int[] v4 = {5,3};
        int[] v5 = {0,2};
        int[] v6 = {2,4};
        int[] v7 = {5,4};


        int[][] graph = new int[][]{v1,v2,v3,v4,v5,v6,v7};

        System.out.println(getKDistanceNodes(graph , 0 , 2 ));
    }

}
