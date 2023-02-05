package graph;

import java.util.*;

/**
 * TODO improve this to logn complexity
 *
 *  Min Cost to Connect All Points
 *
 *  You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them
 *  : |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 *
 * */
public class GraphProblem1 {

    public static class Vertex{
        int x1,y1;

        Vertex(int x,int y){
            x1 = x;
            y1 = y;
        }

        @Override
        public String toString() {
            return "(" + x1 + ", " + y1 + ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return x1 == vertex.x1 && y1 == vertex.y1;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1);
        }
    }
    public static class Edge{
        Vertex v1,v2;
        int distance;

        Edge(int x1_,int y1_ , int x2_ , int y2_){
            this.v1 = new Vertex(x1_,y1_) ;
            this.v2 = new Vertex(x2_,y2_) ;
            this.distance = Math.abs(  Math.abs( ( Math.abs(x1_) - Math.abs(x2_) )) + Math.abs( ( Math.abs(y1_) - Math.abs(y2_)) ));
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", distance=" + distance +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(v1, v2, distance);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return distance == edge.distance && (
                    (Objects.equals(v1, edge.v1) && Objects.equals(v2, edge.v2) ) ||
                    (Objects.equals(v1, edge.v2) && Objects.equals(v2, edge.v1) )
            );
        }
    }

    List<Edge> createEdges(int[][] input){
        List<Edge> edgeList = new LinkedList<>();
        for ( int i=0; i < input.length -1 ; i++){
            for (int j=i+1 ; j < input.length; j++){
                Edge e = new Edge(input[i][0], input[i][1] , input[j][0], input[j][1]);
                if ( !edgeList.contains(e)){
                    edgeList.add( e );
                }
            }
        }
        return edgeList;
    }

    int returnMinCost(int[][] ints){
        List<Edge> edgeList = createEdges(ints);
        edgeList.sort(Comparator.comparingInt(o->o.distance));

        Set<Vertex> visited = new HashSet<>();
        List<Edge> MST = new LinkedList<>();

        edgeList.stream().forEach( e-> {
            if ( !(visited.contains(e.v1) && visited.contains(e.v2)) ) {
                MST.add( e );
                visited.add( e.v1);
                visited.add( e.v2 );
            }
        });
        System.out.println( MST );
        return MST.stream().mapToInt(o-> o.distance).sum();
    }

    public static void main(String[] args) {
        GraphProblem1 graphProblem = new GraphProblem1();
        int[][] ints = {
                new int[]{0,0} ,
                new int[]{2,2} ,
                new int[]{7,0} ,
                new int[]{50,50 }
        };

        int[][] ints2 = {
                new int[]{0,0} ,
                new int[]{2,2} ,
                new int[]{3,10} ,
                new int[]{5,2} ,
                new int[]{7,0}
        };

        int[][] ints3 = {
                new int[]{3,12} ,
                new int[]{-2,5} ,
                new int[]{-4,1}
        };
        System.out.println(graphProblem.returnMinCost( ints ) );
        System.out.println(graphProblem.returnMinCost( ints2 ) );
        System.out.println(graphProblem.returnMinCost( ints3 ) );
    }
}
