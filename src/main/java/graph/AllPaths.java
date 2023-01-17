package graph;

import java.util.HashSet;

public class AllPaths {

    public boolean findAllPaths(int source , int destination, HashSet visited){
        if ( source == destination){
            return true;
        }
        if ( visited.contains(source)){
            return false;
        }
        return false;
    }
}
