package dynamicprogramming.dpontrees;

import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class MaxPathSumLeaf2Leaf {

    /**
     * @param node given node
     * @return sum path for the node , add the data of each node nad
     * */
    int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return node.getVal() + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if ( root == null)
            return 0;

        int left = Math.max( getHeight(root.left) , 0 );
        int right = Math.max( getHeight(root.right) , 0 );

        return Math.max( left + right + root.getVal(), Math.max( diameterOfBinaryTree( root.right), diameterOfBinaryTree( root.left)));
    }

    @Test
    public void test(){
        TreeNode node = new TreeNode(10);

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(-3);
        TreeNode n3 = new TreeNode(-13);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(10);
        TreeNode n7 = new TreeNode(5);
        TreeNode n8 = new TreeNode(17);
        n1.setChild(n3 , n4 );

        n2.setChild(n5,n6);
        n6.setChild(n7,n8);

        node.setChild(n1,n2);


        System.out.println( diameterOfBinaryTree(node));
    }

    @Test
    public void test2(){
        TreeNode node = new TreeNode(-10);

        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        node.setChild(n1,n2);
        n2.setChild(n3 , n4 );

        System.out.println( diameterOfBinaryTree(node));
    }

    @Test
    public void test3(){
        TreeNode node = new TreeNode(10);

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(10);
        TreeNode n6 = new TreeNode(7);

        node.setChild(n1,n2);
        n2.setChild(n3 , n4 );
        n1.setChild(n5,n6);

        System.out.println( diameterOfBinaryTree(node));
    }
}
