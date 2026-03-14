package graph;
import org.junit.jupiter.api.Test;
import java.util.*;


/**
 * Print the topological order of the graph
 *
 * */
public class TopologicalSort {

    int[][] input ;

    private int[] getNodes(){
        Map<Integer,Integer> integerIntegerMap = new HashMap<>();

        for (int[] ints : input){
            integerIntegerMap.put(ints[0],0);
        }
        for (int[] ints : input){
            integerIntegerMap.remove(ints[1]);
        }

        return integerIntegerMap.keySet().stream().mapToInt(i->i).toArray();
    }

    private boolean contains(int[] input , final int target){
        if ( input[0] == target || input[1] == target){
            return true;
        }
        return false;
    }

    private int[] getChildNodes(final int target){
        List<Integer> integerList = new ArrayList<>();
        for ( int[] ints : this.input){
            if ( contains( ints , target)){
                if ( ints[0] == target){
                    integerList.add( ints[1] );
                }
            }
        }

        return integerList.stream().mapToInt(i->i).toArray();
    }

    private void printPath(int i , Set visited){
        if ( visited.contains(i)){ return;}

        visited.add( i );

        for ( int ints : getChildNodes( i )){
            if ( visited.contains( ints)){
                continue;
            }
            printPath( ints , visited);
        }
        System.out.println( i );
    }

    @Test
    public void test(){
        int[] v1 = {1,6};
        int[] v2 = {1,2};
        int[] v3 = {2,3};
        int[] v4 = {3,4};
        int[] v5 = {2,5};
        int[] v6 = {5,3};
        int[] v7 = {5,7};
        int[] v8 = {6,5};
        int[] v9 = {6,7};
        int[] v10 = {7,4};


        this.input = new int[][]{v1,v2,v3,v4,v5,v6,v7,v8,v9,v10};

        this.printPath( 1 , new HashSet());

    }

    @Test
    public void test2(){
        int[] v1 = {3,1};
        int[] v2 = {3,2};
        int[] v3 = {1,0};
        int[] v4 = {2,0};



        this.input = new int[][]{v1,v2,v3,v4};

        this.printPath( 3 , new HashSet());

    }

    @Test
    public void one(){
        int[] v1 = {2,1};

        int[] v3 = {1,4};

        int[] v4 = {4,11};
        int[] v5 = {4,12};
        int[] v6 = {3,4};

        int[] v7 = {6,8};
        int[] v8 = {8,7};
        int[] v9 = {6,7};

        int[] v10 = {7,10};
        int[] v11 = {7,9};

        int[] v12 = {11,7};
        int[] v13 = {11,13};

        int[] v14 = {5,1};
        int[] v15 = {5,4};
        int[] v16 = {5,6};

        int[] v17 = {13,9};
        int[] v18 = {12,13};
        int[] v2 = {2,3};


        this.input = new int[][]{v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18};
        Set<Integer> integerSet = new HashSet();
        for (int node : getNodes()) {
            this.printPath(node , integerSet);
        }
    }
}
