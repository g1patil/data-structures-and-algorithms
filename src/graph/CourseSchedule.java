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
 * 207. Course Schedule
 *
 * Check if we can finish the course in topological order or not.
 * Logic is first build the adjacency list of graph , and also indegree map of the children
 * Add the indegree children with value 0 to queue.
 * While queue is not empty ,add node to order and reduce the indegree on child children
 */
@Quality(Stage.DOCUMENTED)
@Platform(Site.LEETCODE)
public class CourseSchedule {

    Map<Integer , Integer> indegreeMap = new HashMap();
    Map<Integer , List<Integer>> graph = new HashMap();
    Queue<Integer> queue = new LinkedList<>();
    List<Integer> order = new ArrayList<>();


    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        return order.size() == numCourses;

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
        int[][] edges = new int[][]{
                new int[]{2,0},
                new int[]{2,1},
                new int[]{0,3},
                new int[]{1,3}
        };

        System.out.println(canFinish(4 , edges));
    }

    @Test
    public void test_2(){
        int[][] edges = new int[][]{
                new int[]{2,0},
                new int[]{0,2}
        };

        System.out.println(canFinish(4 , edges));
    }

    @Test
    public void test_3(){
        int[][] edges = new int[][]{
                new int[]{1,0},
                new int[]{2,0},
                new int[]{3,1},
                new int[]{3,2}
        };

        System.out.println(canFinish(4 , edges));
        System.out.println(order);
    }

    @Test
    public void test_4(){
        int[][] edges = new int[][]{
                new int[]{1,4},
                new int[]{2,4},
                new int[]{3,1},
                new int[]{3,2}
        };

        System.out.println(canFinish(5 , edges));
        System.out.println(order);
    }

    @Test
    public void test_5(){
        int[][] edges = new int[][]{
                new int[]{1,0}
        };

        System.out.println(canFinish(2 , edges));
        System.out.println(order);
    }

}
