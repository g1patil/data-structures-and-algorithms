package disjointset;

public class UnionByRank {

    private int[] root;
    private int[] rank;

    public UnionByRank(int size_){
        root = new int[size_];

        for ( int index = 0 ; index < size_ ; index ++){
            root[index] = index ;
            rank[index] = 1 ;
        }
    }

    private int find(int x_){
        while ( x_ != root[x_])
            x_ = root[ x_];

        return x_ ;
    }

    private void union(int x_ , int y_){
        int rootX = find( x_ );
        int rootY = find( y_ );

        if ( rootX != rootY){
            if ( rank[ rootX ] > rank[ rootY] ){
                root[rootY] = rootX ;
            } else if ( rank[ rootY ] > rank[ rootX] ){
                root[rootX] = rootY ;
            } else {
                root[rootY] = rootX ;
                rank[rootX] +=1;
            }
        }
    }
}
