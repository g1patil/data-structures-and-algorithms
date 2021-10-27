package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCA {

    private List<Integer> integerList = new ArrayList<>();
    private Stack<Integer> integerStack = new Stack<>();

    public void printRoute(TreeNode root , int index){
        if ( root == null )
            return;

        {
            this.integerStack.push( root.data );
            integerList.add( index);
        }
        printRoute( root.leftNode , ++index );
        index--;
        if ( !root.isLeaf() && root.leftNode != null ){
            integerStack.push(root.data);
            integerList.add(index);
        }
        printRoute( root.rightNode  , ++index );
        index -- ;
        if ( !root.isLeaf() && root.rightNode != null ){
            this.integerStack.push(root.data);
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
        System.out.println( integerStack );
        System.out.println( this.integerList );

    }
}
