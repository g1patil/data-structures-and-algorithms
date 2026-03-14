package disjointset;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * Union find algorithm
 * 1319. Number of Operations to Make Network Connected
 */
@Quality(Stage.DOCUMENTED)
@Platform(Site.LEETCODE)
public class MakeNetworkConnected {


    int[] root;
    int[] componentSizes;
    private int numberOfComponents;

    public void initialize(int _size){
        this.root = new int[_size];
        this.componentSizes = new int[_size];

        for (int i = 0; i < _size; i++) {
            this.root[i] = i ;
            this.componentSizes[i] = i ;
        }
        numberOfComponents = _size;

    }
    public int makeConnected(int n, int[][] connections) {
        initialize(n);
        for(int[] pair : connections){
            unify(pair[0], pair[1]);
        }

        return connections.length >= n -1 ? getNumberOfComponents() -1 : -1;

    }

    private int find(int x_){
        while ( x_ != root[x_])
            x_ = root[ x_];

        return x_ ;
    }

    private boolean areConnected(int x , int y){
        return find(x) == find(y);
    }

    private int getNumberOfComponents(){
        return numberOfComponents;
    }

    public void unify(int x, int y) {
        if (areConnected(x,y))
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

        numberOfComponents -- ;


    }
}
