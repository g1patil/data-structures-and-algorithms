package disjointset;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 684. Redundant Connection
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class RedundantConnection {

    int[] root ;
    public int[] init(int[][] edges){
        int[] root = new int[2 * edges.length];

        for (int i = 0; i < root.length; i++) {
            root[i] = i ;
        }

        return root;
    }
    public int[] findRedundantConnection(int[][] edges) {
        this.root = init(edges);
        int[] result = new int[2];

        for (int[] e : edges){
            if (!unify(e[0],e[1]))
                result = e;
        }

        return result;
    }

    public boolean unify(int s , int t){
        if (connected(s , t))
            return false;
        root[getRoot(s)] = getRoot(t) ;
        return true;
    }

    public boolean connected(int s , int t){
        return getRoot(s) == getRoot(t);
    }

    public int getRoot(int root){
        while (this.root[root] != root)
            root = this.root[root];
        return root;
    }

    @Test
    public void test_(){

        findRedundantConnection(
                new int[][]{
                        new int[]{1,2},
                        new int[]{1,3},
                        new int[]{2,3}
                }
        );
    }


}
