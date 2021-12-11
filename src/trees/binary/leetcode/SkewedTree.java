package trees.binary.leetcode;

import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author jivanpatil
 * WIP
 * 897. Increasing Order Search Tree
 * */
public class SkewedTree {

    TreeNode result ;

    private void addNode(int data){
        if (result== null){
            result = new TreeNode(data);
            return;
        }

        TreeNode temp = result;

        while (temp.right != null)
            temp = temp.right;

        temp.setChild(null,new TreeNode(data));
    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n3.setChild(null, n4);
        n4.setChild(null, n5);


        n1.setChild(n2,n3);
        n1 = makeSkewedTreeDecreasing(n1);
        n1.printTree(n1);
    }

    @Test
    public void test_2(){
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n3.setChild(null, n4);
        n4.setChild(null, n5);


        n1.setChild(n2,n3);
        n1 = makeSkewedTreeIncreasing(n1);
        n1.printTree(n1);
    }

    /**
     * Builds the skewed tree in decreasing order.
     * @param n1 root node for that context
     * */
    private TreeNode makeSkewedTreeDecreasing(TreeNode n1) {
        if ( n1 == null)
            return n1;

        makeSkewedTreeDecreasing(n1.right);
        addNode(n1.getData());
        makeSkewedTreeDecreasing(n1.left);
        
        return result;
    }

    /**
     * Builds the skewed tree in increasing order
     * TODO
     * */
    private TreeNode makeSkewedTreeIncreasing(TreeNode n1) {
        if ( n1 == null)
            return n1;

        makeSkewedTreeIncreasing(n1.left);
        addNode(n1.getData());
        makeSkewedTreeIncreasing(n1.right);

        return result;
    }
}
