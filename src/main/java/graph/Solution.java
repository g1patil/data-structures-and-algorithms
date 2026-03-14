package graph;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

class Solution {
    // Prim Algorithm
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int size = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(Comparator.comparing(x -> x.date));
        boolean[] visited = new boolean[size];
        int result = 0;
        int count = size - 1;
        // Add all edges from points[0] vertexs
        for (int j = 1; j < size; j++) {
            // Calculate the distance between two coordinates.
            int[] coordinate1 = points[0];
            int[] coordinate2 = points[j];
            int cost = Math.abs(coordinate1[0] - coordinate2[0]) +
                    Math.abs(coordinate1[1] - coordinate2[1]);
            Edge edge = new Edge(0, j, cost);
            pq.add(edge);
        }
        visited[0] = true;

        while (pq.size() > 0 && count > 0) {
            Edge e = pq.poll();
            int point1 = e.point1;
            int point2 = e.point2;
            int cost = e.cost;
            if ( !visited[point2] ) {
                result += cost;
                visited[point2] = true;
                for (int j = 0; j < size; j++ ) {
                    if (!visited[j]) {
                        int distance = Math.abs(points[point2][0] - points[j][0]) +
                                Math.abs(points[point2][1] - points[j][1]);
                        pq.add(new Edge(point2, j, distance));
                    }
                }
                count--;
            }
        }
        return result;
    }

    class Edge {
        int point1;
        int point2;
        int cost;
        Date date;

        Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = {
                new int[]{0,0} ,
                new int[]{2,2} ,
                new int[]{7,0} ,
                new int[]{50,50 }
        };

        System.out.println( solution.minCostConnectPoints( ints ));
    }
}
