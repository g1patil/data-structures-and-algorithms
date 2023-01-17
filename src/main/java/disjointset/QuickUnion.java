package disjointset;

public class QuickUnion {
    private int[] root;

    public QuickUnion(int size_){
        root = new int[size_];

        for ( int index = 0 ; index < size_ ; index ++)
            root[index] = index;
    }

    private int findRoot(int val_){
        while ( val_ != root[val_]){
            val_ = root[val_];
        }
        return val_;
    }

    public void union(int x_ , int y_){
        int rootX = root[x_];
        int rootY = root[y_];

        if ( rootX != rootY){
            rootY = rootX ;
        }
    }


}
