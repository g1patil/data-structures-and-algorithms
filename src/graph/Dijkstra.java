package graph;

// Java Program to Implement Dijkstra's Algorithm
// Using Priority Queue

// Importing utility classes
import java.util.*;

// Main class DPQ
public class Dijkstra {

    // Member variables of this class
    private int dist[];
    private Set<Integer> visited;
    private PriorityQueue<Node> pq;
    private int path[];
    // Number of vertices
    private int V;
    List<List<Node> > adj;

    // Constructor of this class
    public Dijkstra(int V)
    {

        // This keyword refers to current object itself
        this.V = V;
        dist = new int[V];
        path = new int[V];
        visited = new HashSet<>();
        pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.cost));
    }

    // Method 1
    // Dijkstra's Algorithm
    public void dijkstra(List<List<Node> > adj, int src)
    {
        this.adj = adj;
        //initialize the distance array
        for ( int i = 0 ; i < dist.length ; i ++){
            dist[i] = Integer.MAX_VALUE;
            path[i] = -1 ;
        }

        dist[src] = 0;
        pq.add( new Node(0,0));
        while ( ! pq.isEmpty() ){
            Node node = pq.remove();

            if ( visited.contains( node.node)){
                continue;
            }

            this.visited.add( node.node);
            // add the neighbours.
            e_Neighbours( node.node );
        }

    }

    // Method 2
    // To process all the neighbours
    // of the passed node
    private void e_Neighbours(int u)
    {
        for (Node v : this.adj.get(u)) {
            int currentDistance = v.cost;
            int newDistance = currentDistance + this.dist[u];

            if ( newDistance < this.dist[v.node]){
                this.dist[v.node] = newDistance;
                this.path[v.node] = u ;
            }

            if ( ! this.visited.contains(v.node)){
                this.pq.add( new Node( v.node , newDistance ));
            }
        }
    }

    // Main driver method
    public static void main(String arg[])
    {

        int V = 7;
        int source = 0;

        // Adjacency list representation of the
        // connected edges by declaring List class object
        // Declaring object of type List<Node>
        List<List<Node> > adj
                = new ArrayList<>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Inputs for the GFG(dpq) graph
        adj.get(0).add(new Node(2, 3));
        adj.get(0).add(new Node(1, 2));

        adj.get(1).add(new Node(3, 6));
        adj.get(1).add(new Node(2, 0));
        adj.get(1).add(new Node(4, 5));

        adj.get(2).add(new Node(5, 1));

        adj.get(3).add(new Node(2, 2));

        adj.get(4).add(new Node(3, 1));
        adj.get(4).add(new Node(6, 2));

        adj.get(5).add(new Node(3, 2));
        adj.get(5).add(new Node(4, 1));
        adj.get(5).add(new Node(6, 5));

        // Calculating the single source shortest path
        Dijkstra dpq = new Dijkstra(V);
        dpq.dijkstra(adj, source);

        // Printing the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");

        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.dist[i] );

        int dest = 6;
        List<Integer> integerList = new LinkedList<>();
        integerList.add( dest );
        while ( dest != source ){
            dest = dpq.path[dest];
            integerList.add( dest );
        }
        System.out.println( integerList );
    }
}

// Class 2
// Helper class implementing Comparator interface
// Representing a node in the graph
class Node  {

    // Member variables of this class
    public int node;
    public int cost;

    // Constructors of this class

    // Constructor 1
    public Node() {}

    // Constructor 2
    public Node(int node, int cost)
    {

        // This keyword refers to current instance itself
        this.node = node;
        this.cost = cost;
    }

}

