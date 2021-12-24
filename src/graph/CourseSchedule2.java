package graph;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author g1patil
 */
public class CourseSchedule2 {

    int[][] input;

    private int[] sortKahn(int[][] input) {

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


        if (index!= nodeDegreesMap.size())
            return new int[]{};

        return topologicalOrder;
    }

    @Test
    public void test_(){
        System.out.println(findOrder(4 , new int[][]{
                new int[]{3,1},
                new int[]{3,2},
                new int[]{1,0},
                new int[]{2,0}
        }));
    }

    @Test
    public void test_2(){
        System.out.println(findOrder(3 , new int[][]{
                new int[]{0,2},
                new int[]{2,0},
                new int[]{1,2}
        }));
    }
}
