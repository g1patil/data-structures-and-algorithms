package dynamicprogramming.dpontrees;

import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class MaxNodeSum {

    public int getMaxSum(TreeNode root){
        if ( root == null)
            return 0 ;

        return root.getVal() + Math.max( getMaxSum(root.left) , getMaxSum(root.right));
    }

    @Test
    public void test(){
        TreeNode node = new TreeNode(10);

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        node.setChild(n1,n5);
        n1.setChild(n2,n3);
        n3.setChild(n7,null);
        n4.setChild(n6, null );
        n5.setChild(n4, n9);
        n9.setChild(null , n8 );

        System.out.println( getMaxSum(node));
    }
}
