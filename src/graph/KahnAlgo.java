package graph;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Sort the vertices of the graph in topological order using Kahn's algorithms.
 *
 * Extra credit : convert this into generics. Should be able to used by strings. Even fancier , by objects.
 * */
public class KahnAlgo {

    int[][] input;

    private void sortKahn(int[][] input) {

        Map<Integer, Integer> nodeDegreesMap = new HashMap<>();
        int[] topologicalOrder = new int[input.length];
        Queue<Integer> integers = new PriorityQueue<>();

        //initialize the degree of all the vertices
        for ( int[] i : input){
            if ( nodeDegreesMap.containsKey(i[1])){
                nodeDegreesMap.put( i[1] , nodeDegreesMap.get(i[1]) + 1);
            } else {
                nodeDegreesMap.put( i[1], 1);
            }

            if ( ! nodeDegreesMap.containsKey(i[0])){
                nodeDegreesMap.put( i[0] , 0 );
            }

        }

        //add the nodes with the degree zero in the queue
        for (Integer integer : nodeDegreesMap.keySet().stream().filter(key -> nodeDegreesMap.get(key) == 0).collect(Collectors.toList())) {
            integers.add( integer );
        }

        //process the queue : remove the node and reduce the degree of all connected
        //add the nodes with zero degree in the queue
        // add the current node to the topological order
        int index = 0;
        while ( ! integers.isEmpty() ){
            int element = integers.poll();
            topologicalOrder[index++] = element ;

            //reduce the degree
            Arrays
                    .stream(input).filter( a  -> a[0] == element )
                    .collect(Collectors.toList())
                    .forEach( i-> {
                        nodeDegreesMap.put( i[1] , nodeDegreesMap.get(i[1]) -1 );
                        if ( nodeDegreesMap.get(i[1]) == 0){
                            integers.add( i[1]);
                        }
                    });
        }

        for (int i : topologicalOrder) {
            System.out.print ( i + " ");
        }
    }

    @Test
    public void one(){
        int[] v1 = {2,1};

        int[] v3 = {1,4};

        int[] v4 = {4,11};
        int[] v5 = {4,12};
        int[] v6 = {3,4};

        int[] v7 = {6,8};
        int[] v8 = {8,7};
        int[] v9 = {6,7};

        int[] v10 = {7,10};
        int[] v11 = {7,9};

        int[] v12 = {11,7};
        int[] v13 = {11,13};

        int[] v14 = {5,1};
        int[] v15 = {5,4};
        int[] v16 = {5,6};

        int[] v17 = {13,9};
        int[] v18 = {12,13};
        int[] v2 = {2,3};


        this.input = new int[][]{v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18};
        this.sortKahn(this.input);
    }

    @Test
    public void two(){
        int[] v1 = {1,2};
        int[] v2 = {2,3};
        int[] v3 = {2,5};
        int[] v4 = {1,6};

        int[] v5 = {3,4};
        int[] v6 = {5,3};

        int[] v7 = {5,7};
        int[] v8 = {6,5};
        int[] v9 = {6,7};

        int[] v10 = {7,4};



        this.input = new int[][]{v1,v2,v3,v4,v5,v6,v7,v8,v9,v10};
        this.sortKahn(this.input);
    }


}
