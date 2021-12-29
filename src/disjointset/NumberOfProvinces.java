package disjointset;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 *
 * 547. Number of Provinces
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class NumberOfProvinces {

    int[] root ;
    int numberOfProvinces;
    int[] componentSizes;

    public void initialize(int size){
        this.root = new int[size];

        for (int i = 0; i < size; i++) {
            this.root[i] = i ;
            this.componentSizes[i] = i ;
        }

        numberOfProvinces = size;
    }

    public int find(int x){
        while ( x != root[x])
            x = root[x];

        return x ;
    }

    public boolean connected(int x , int y){
        return find(x) == find(y);
    }

    public void unify(int x , int y){
        if ( connected(x,y))
            return;

        int root1 = find(x);
        int root2 = find(y);

        if (componentSizes[root1] < componentSizes[root2]){
            componentSizes[root2]+=componentSizes[root1];
            root[root1] = root2;
            componentSizes[root1] = 0;
        } else {
            componentSizes[root1]+=componentSizes[root2];
            root[root2] = root1 ;
            componentSizes[root2] = 0;
        }

        numberOfProvinces -- ;


    }

    public int findCircleNum(int[][] isConnected) {
        initialize(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j <= i ; j++) {
                if (isConnected[i][j] == 1)
                    unify(i , j);
            }
        }

        return numberOfProvinces;

    }
}
