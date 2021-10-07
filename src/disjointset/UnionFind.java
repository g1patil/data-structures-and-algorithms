package disjointset;

import org.junit.Test;

public class UnionFind {
    private int[] root;

    public UnionFind(int size_){
        root = new int[size_];

        for ( int index = 0 ; index < size_ ; index ++)
            root[index] = index;
    }

    private int findRoot(int val_){
        return this.root[val_];
    }

    private boolean areConnected(int x , int y){
        return findRoot(x) == findRoot(y);
    }

    private void union(int x_ , int y_){
        if ( findRoot(x_) == findRoot(y_))
            return;
        root[y_] = root[x_];

    }

    public void union2(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    void print(){
        for ( int i : root)
            System.out.print( i + " " );

        System.out.println();
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(6);
        unionFind.print();
        unionFind.union(0 , 1);
        unionFind.union(0 , 3 );
        unionFind.union(3 , 4 );
        unionFind.union(5 , 2 );

        unionFind.union(4 , 5 );
        unionFind.print();

        System.out.println( unionFind.areConnected( 0,2));
    }
}
