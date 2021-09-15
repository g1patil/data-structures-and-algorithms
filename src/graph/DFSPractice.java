package graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class DFSPractice {

    private int[][] input;

    public boolean edgeExist(final int souce, final int destination){
        for (int[] ints : input) {
            if ( (ints[0] == souce && ints[1] == destination) || (ints[1] == souce && ints[0] == destination) ){
                return true;
            }
        }
        return false;
    }

    public boolean hasPath(int start, int end , HashSet<Integer> visited){
        if (visited.contains(start)){
            return false;
        }
        if(edgeExist(start,end))
            return true;
        visited.add(start);
        for(int[] node : this.input){
            if ( start == node[0] || start == node[1]){
                int element = node[0] == start ? node[1] : node[0];
                if (  hasPath(element , end , visited) ){
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
    public boolean validPath( int[][] edges, int start, int end) {
        HashSet<Integer> visited = new HashSet<>();
        this.input = edges;
        return hasPath(start, end , visited);
    }

    @Test
    public void test(){
        int[] one = {0,1};
        int[] two = {1,2};
        int[] three = {2,0};

        this.input = new int[][]{one, two , three};

        Assert.assertTrue( validPath( this.input , 1 , 2));
        Assert.assertFalse( validPath( this.input , 1 , 3));
    }

    @Test
    public void two(){
        int[] v1 = {0,1};
        int[] v2 = {1,2};
        int[] v3 = {2,0};

        int[] v4 = {3,4};
        int[] v5 = {4,5};
        int[] v6 = {5,6};
        int[] v7 = {6,3};

        int[] v8 = {2,5};

        this.input = new int[][]{v1,v2,v3,v4,v5,v6,v7,v8};

        Assert.assertTrue( validPath( this.input , 0 , 6));
    }
}


