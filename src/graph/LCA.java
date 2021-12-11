package graph;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LCA {

    private List<Integer> integerList = new ArrayList<>();
    private List<Integer> integerArrayList = new ArrayList<>();

    private void addElement(){

    }

    private int getLCA(final TreeNode n1 , final TreeNode n2){
        int m1 = integerArrayList.indexOf(n1.data);
        int m2 = integerArrayList.indexOf(n2.data);
        int treeNode = -1  ;
        int minHeight  = Integer.MAX_VALUE;
        for (int i = Math.min( m1 , m2 ); i < Math.max( m1, m2 ); i++) {
            if ( integerList.get(i) < minHeight ){
                minHeight = integerList.get(i);
                treeNode = integerArrayList.get(i);
            }
        }
        return treeNode ;
    }

    public void printRoute(TreeNode root , int index){
        if ( root == null )
            return;

        {
            this.integerArrayList.add( root.data );
            integerList.add( index);
        }
        printRoute( root.leftNode , ++index );
        index--;
        if ( !root.isLeaf() && root.leftNode != null ){
            integerArrayList.add(root.data);
            integerList.add(index);
        }
        printRoute( root.rightNode  , ++index );
        index -- ;
        if ( !root.isLeaf() && root.rightNode != null ){
            this.integerArrayList.add(root.data);
            integerList.add( index);
        }
    }

    @Test
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7 );
        TreeNode node8 = new TreeNode(8);

        node1.setChild( node2 , node3 );
        node2.setChild(node4 , node5);
        node3.setChild(node6, node7);
        node5.setChild(null ,node8 );

        this.printRoute( node1 , 0 );
        System.out.println(integerArrayList);
        System.out.println( this.integerList );
        System.out.println( this.getLCA(node2 ,  node8) );

    }
}
