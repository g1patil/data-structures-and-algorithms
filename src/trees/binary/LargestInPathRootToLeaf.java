package trees.binary;

import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class LargestInPathRootToLeaf {


    public void printLargestInPath(TreeNode root){
        printLargestInPathHelper(root,Integer.MIN_VALUE);
    }

    public void printLargestInPathHelper(TreeNode root , int max){

        if (root == null){
            System.out.println(max);
            return ;
        }

        if (root.left == null && root.right == null){
            System.out.println(Math.max(max , root.val));
            return;
        }
        if (root.left!=null)
            printLargestInPathHelper(root.left , Math.max(max , root.val));
        if (root.right != null)
            printLargestInPathHelper(root.right , Math.max(max , root.val));

    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(-10);
        TreeNode n1 = new TreeNode(-5);
        TreeNode n2 = new TreeNode(-6);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        root.setChild(n1,n2);
        n1.setChild(n3,n4);
        n2.setChild(n5,n6);
        printLargestInPath(root);
    }
}
