package graph;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 *
 * 2097. Valid Arrangement of Pairs
 */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class ValidArrangementPairs {

    Map<Integer , Queue<Integer>> graphMap = new HashMap<>();
    Map<Integer , int[]> degreeMap = new HashMap<>();
    int[][] result ;

    public int[][] validArrangement(int[][] pairs) {
        buildGraph(pairs , pairs.length);
        buildPairs(getStartNode() , pairs.length -1 );
        return result;
    }


    public int buildPairs(int startNode , int index){
        Queue<Integer> nextPairs = graphMap.get(startNode);
        if (nextPairs == null)
            return index;

        while (nextPairs.size() > 0){
            int pair = nextPairs.poll();
            index = buildPairs(pair , index );
            result[index--] = new int[]{startNode , pair};

        }
        return index;
    }

    public void buildGraph(int[][] pairs , int size){
        for(int[] pair : pairs){
            int source = pair[0];
            int destination = pair[1];


            Queue<Integer> integers = graphMap.get(source);


            if (integers == null){
                integers = new LinkedList<>();
                graphMap.put( source, integers);
            }
            integers.add(destination);

            int[] degreeSource = degreeMap.get(source);
            int[] degreeDestination = degreeMap.get(destination);

            if (degreeSource == null){
                degreeSource = new int[2];
                degreeMap.put( source , degreeSource);
            }

            if (degreeDestination == null){
                degreeDestination = new int[2];
                degreeMap.put( destination , degreeDestination);
            }

            degreeSource[0]++;
            degreeDestination[1]++;
        }

        result = new int[size][2];
    }


    public int getStartNode(){
        for (Map.Entry<Integer , int[]> keyValue : degreeMap.entrySet()){
            int key = keyValue.getKey();

            int outDegree = keyValue.getValue()[0];
            int inDegree = keyValue.getValue()[1];
            if (outDegree - inDegree == 1)
                return key;
        }

        return degreeMap.keySet().stream().findFirst().get();
    }

    @Test
    public void test_(){
        int[][] matrix = new int[][]{
                new int[]{5,1},
                new int[]{4,5},
                new int[]{11,9},
                new int[]{9,4}
        };

        System.out.println(validArrangement(matrix));
    }

    @Test
    public void test_2(){
        int[][] matrix = new int[][]{
                new int[]{1,3},
                new int[]{3,2},
                new int[]{2,1}
        };

        System.out.println(validArrangement(matrix));
    }

}
