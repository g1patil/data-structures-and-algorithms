package graph;

import org.junit.Test;
import java.util.*;
/**
 * Clone the given undirected graph.
 *
 * */
public class CloneGraph {
    Set<Vertex> built;
    Vertex newRoot;

    public static class Vertex {
        int data;
        List<Vertex> child = new ArrayList<>();

        Vertex(int _data){ this.data = _data;}
        int getData(){
            return this.data;
        }
    }
    Vertex createNode(Integer data){
        Optional<Vertex> optionalBuilt = built.stream().filter(n-> n.getData() == data).findFirst();
        return optionalBuilt.isEmpty() ? new Vertex(data) : optionalBuilt.get();

    }
    Vertex createClone(Vertex s , Set<Vertex> built){
        this.built = built;
        Vertex newNode = createNode( s.data );
        this.built.add( newNode );

        if ( !newNode.child.isEmpty()){
            return newNode;
        }
        for ( Vertex child : s.child){
            Vertex childNode = createNode( child.data);
            newNode.child.add( childNode);
            this.built.add( childNode );
        }
        return newNode;
    }
    void cloneGraph(Vertex node , Set<Vertex> visited , Set<Vertex> built){
        if ( visited.contains( node) ){
            return;
        }

        Vertex newNode = createClone( node , built);
        visited.add( node );

        if ( built.size() == 1){
            this.newRoot = newNode;
        }
        for ( Vertex child : node.child){
            cloneGraph( child , visited , built);
        }
        return;
    }

    @Test
    public void test(){
        Vertex v0 = new Vertex( 0);
        Vertex v1 = new Vertex( 1);
        Vertex v2 = new Vertex( 2);

        v0.child.add( v1 );
        v0.child.add( v2 );

        v1.child.add( v0 );
        v2.child.add( v0 );

        Set<Vertex > visited = new HashSet<>();
        Set<Vertex > built = new HashSet<>();
        cloneGraph( v0 , visited , built );

        System.out.println( newRoot );
    }
}
