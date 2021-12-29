package disjointset.theory;

import disjointset.UnionFind;

/**
 * @author g1patil
 */
public class UnionFindTheory {

    /* Initialize the root array , component size */
    int[] root;
    int[] componentSizes;
    private int numberOfComponents;

    /* Assign all the elements root to itself*/
    public UnionFindTheory(int _size){
        this.root = new int[_size];
        this.componentSizes = new int[_size];

        for (int i = 0; i < _size; i++) {
            this.root[i] = i ;
            this.componentSizes[i] = i ;
        }
        numberOfComponents = _size;
    }

    /* Find the root of x . Until found the self loop
    * keep going up
    * */
    private int find(int x_){
        while ( x_ != root[x_])
            x_ = root[ x_];

        return x_ ;
    }

    /**
     * Checks if two elements are connected or not.
     * If the root of them are equal then,
     * they are connected
     * */
    private boolean areConnected(int x , int y){
        return find(x) == find(y);
    }

    private int getSize(int x){
        return componentSizes[find(x)];
    }

    /**
     * Returns the total number of independent components
     * */
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

    public static void main(String[] args) {
        UnionFindTheory unionFind = new UnionFindTheory(6);
        unionFind.unify(0,1);
        unionFind.unify(0,2);
        unionFind.unify(0,3);
        unionFind.unify(1,2);
        unionFind.unify(1,3);
        System.out.println(unionFind.getNumberOfComponents());
    }

}
