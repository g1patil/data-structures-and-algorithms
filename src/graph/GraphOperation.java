package graph;

import java.util.*;

public class GraphOperation {

    private Map<Integer, Node> nodeLookUp = new HashMap<>();

    public Node getNode(final int _data){
        return nodeLookUp.get(_data);
    }
    public static class Node {
        private int data;
        private List<Node> adjacent = new LinkedList<>();

        Node(final int _data){
            this.data = _data;
        }
    }

    public void addEdge(final int _source , final int _dest){
        Node s = getNode(_source);
        s.adjacent.add(new Node(_dest));
    }

    public boolean hasDFS(int _source, int _destination){
        Node sourceNode = getNode(_source);
        Node destNode = getNode(_destination);

        HashSet<Integer> visited = new HashSet();
        return hasDFS(sourceNode, destNode , visited);
    }

    public boolean hasDFS(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source.data)){
            return false;
        }
        visited.add(source.data);
        if(source == destination){
            return true;
        }

        for ( Node child : source.adjacent){
            if ( hasDFS(child , destination , visited)){
                return true;
            }
        }
        return false;
    }


}
