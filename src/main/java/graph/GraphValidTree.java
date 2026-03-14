package graph;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 261. Graph Valid Tree
 * Validate if the graph has the valid tree
 *
 * Algo : Implement Union find the make sure there is no loop,
 * and also the total number of connected components are one.
 * @author g1patil
 * */
@Quality(value = Stage.TESTED)
@Platform(Site.LEETCODE)
public class GraphValidTree {

    int[] root;
    int[] componentsLength;
    int numberOfGraphs;

    public void initialize(int size){
        this.numberOfGraphs = size ;
        this.root = new int[size];
        this.componentsLength = new int[size];

        for (int i = 0; i < size; i++) {
            this.root[i] = i ;
            this.componentsLength[i] = i ;
        }
    }

    public boolean connected(int x  , int y){
        return find(x) == find(y);
    }
    public int find(int _x){
        while (_x != root[_x])
            _x = root[_x];
        return _x;
    }

    public boolean unifyIfPossible(int x , int y){
        if (connected(x , y))
            return false;

        int root1 = find(x);
        int root2 = find(y);

        if (componentsLength[root1]< componentsLength[root2]){
            componentsLength[root2]+=componentsLength[root1];
            root[root1] = root2;
            componentsLength[root1] = 0;
        } else {
            componentsLength[root1]+=componentsLength[root2];
            root[root2] = root1;
            componentsLength[root2] = 0;
        }
        numberOfGraphs--;
        return true;
    }


    public boolean validTree(int n, int[][] edges) {
        initialize(n);

        for (int[] edge : edges){
            if (!unifyIfPossible(edge[0], edge[1])){
                return false;
            }
        }
        return numberOfGraphs == 1;
    }

    @Test
    public void test_(){
        int[][] edges = {
          new int[]{0,1},
          new int[]{2,1},
          new int[]{2,0},
          new int[]{2,4}
        };
        System.out.println(validTree(5 , edges));
    }


}
