package graph;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author g1patil
 * 210. Course Schedule II
 *
 */
@Quality(Stage.DOCUMENTED)
@Platform(Site.LEETCODE)
public class CourseSchedule2 {

    Map<Integer , Integer> indegreeMap = new HashMap();
    Map<Integer , List<Integer>> graph = new HashMap();
    Queue<Integer> queue = new LinkedList<>();
    List<Integer> order = new ArrayList<>();
    int[] _order ;


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses ,prerequisites);

        while (!queue.isEmpty()){
            int num = queue.poll();
            order.add(num);

            List child = graph.get(num);
            if (child == null)
                continue;;

            /* reduce the in-degree on the children */
            graph.get(num).forEach(i->{
                int previousDegree =  indegreeMap.get(i);
                indegreeMap.put( i , previousDegree - 1) ;

                /* if the previous degree is 1 then add to queue */
                if (previousDegree == 1)
                    queue.add(i);
            });

        }

        /* if the final order has less children than total size then, we are missing node*/
        if(order.size() != numCourses)
            return new int[0];

        /* reverse the list and convert to array*/
        _order = new int[numCourses];
        int index = _order.length - 1;
        for (int i : order) {
            _order[index] = i ;
            index --;
        }
        return _order;

    }

    /**
     * Converts the 2D array to adjacency list of graph. Builds the in-degree hashmap of the children
     * */
    public void buildGraph(int numCourses , int[][] prerequisites){
        for(int[] edge : prerequisites){
            graph.putIfAbsent(edge[0] , new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            indegreeMap.putIfAbsent(edge[0] , 0);
            indegreeMap.putIfAbsent(edge[1] , 0);
            indegreeMap.put( edge[1] , indegreeMap.get(edge[1]) + 1 );
        }

        for(int i=0 ; i < numCourses ; i ++){
            if(!indegreeMap.containsKey(i)){
                indegreeMap.put(i , 0 );
            }
        }

        /* Add the children with in-degree 0 to the map */
        queue.addAll(indegreeMap.keySet().stream().filter(k -> indegreeMap.get(k) == 0).collect(Collectors.toList()));
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
