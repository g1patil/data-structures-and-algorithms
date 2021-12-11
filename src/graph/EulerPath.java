package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EulerPath {

    List<ArrayList<Integer>> graph;
    int[] in , out ;
    int numberOfVertices,numberOfEdges;
    List<Integer> integerList;

    private List<Integer> getEulerPath(){
        calculateDegree();
        if ( eulerPathExist()){
            dfsTree( getStartNode() );
        }
        return integerList;
    }

    private void calculateDegree(){
        this.out = new int[numberOfVertices];
        this.in = new int[numberOfVertices];

        for (int from = 0; from < this.graph.size() ; from++) {
            for ( Integer to : this.graph.get( from )){
                this.out[from]++;
                this.in[to]++;
                numberOfEdges++;
            }
        }
    }

    private int getStartNode(){
        int start = 0 ;

        for (int i = 0; i < numberOfVertices; i++) {
            if ( out[i] - in[i] == 1 )
                return i;
            if ( out[i] > 0)
                start = i;
        }
        return start;
    }

    private boolean eulerPathExist(){
        int startNode = 0 , endNode = 0;
        for (int i = 0; i < numberOfVertices; i++) {
            if ( in[i] - out[i] > 1 || out[i] - in[i] > 1)
                return false;
            if ( in[i] - out[i] == 1)
                endNode++;
            if ( out[i] - in[i] == 1 )
                startNode++;

        }

        return  ( startNode == 0 && endNode ==0 ) || ( startNode == 1 && endNode == 1 );

    }

    private void dfsTree(int startNode){

        while ( out[startNode] != 0){
            int nextNode = this.graph.get( startNode ).get( --out[startNode] );
            dfsTree( nextNode );
        }
        this.integerList.add( startNode );
    }

    private void initializeGraph(final int size){
        this.graph = new ArrayList<>(size);
        this.numberOfVertices = size ;
        for (int i = 0; i < size; i++) {
            this.graph.add( new ArrayList<>());
        }
        this.integerList = new LinkedList<>();
    }

    private void addDirectedEdge(int from , int to){
        this.graph.get( from ).add( to );
    }

    @Test
    public void test(){
        initializeGraph(7);

        addDirectedEdge(1, 2);
        addDirectedEdge(1, 3);
        addDirectedEdge(2, 2);
        addDirectedEdge(2, 4);
        addDirectedEdge(2, 4);
        addDirectedEdge(3, 1);
        addDirectedEdge(3, 2);
        addDirectedEdge(3, 5);
        addDirectedEdge(4, 3);
        addDirectedEdge(4, 6);
        addDirectedEdge(5, 6);
        addDirectedEdge(6, 3);

        // Outputs path: [1, 3, 5, 6, 3, 2, 4, 3, 1, 2, 2, 4, 6]
        System.out.println( this.getEulerPath() );

    }
}
