package trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumLeaf {

//    private int getLeafSum(Node root){
//        if ( root == null){ return  0;}
//
//        if ( root.left == null && root.right == null){ return  root.data ;}
//
//        return getLeafSum( root.left) + getLeafSum( root.right);
//    }
//
//    @Test
//    public void test(){
//        Node n1 = new Node(1);
//        Node n2 = new Node(2);
//        Node n3 = new Node(3);
//        Node n4 = new Node(5);
//        Node n5 = new Node(6);
//        Node n6 = new Node(9);
//        Node n7 = new Node(10);
//        Node n8 = new Node(-1);
//        Node n9 = new Node(3);
//
//        n1.left = n2;
//        n1.right = n3;
//
//        n2.left = n4;
//        n2.right = n5;
//
//        n3.left = n6;
//        n3.right = n7;
//
//        n4.left = n8;
//        n6.right = n9;
//
//        Assertions.assertEquals(18 , getLeafSum(n1));
//    }
}
