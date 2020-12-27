package trees.binary;

import data.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class MergeTwoBinaryTrees {

    /*
     * Merge two trees
     * */
    private TreeNode mergeTrees(TreeNode first, TreeNode second){

        if (first == null && second == null){
            return null;
        }

        if( first == null && second != null ){
            return second;
        }

        if( second == null && first!= null ){
            return first;
        }

        first.setData( first.getData() + second.getData());
        first.left = mergeTrees( first.left, second.left);
        first.right = mergeTrees( first.right, second.right);

        return first;
    }

    @Test
    public void test(){
        TreeNode root1 = new TreeNode(10);
        TreeNode l= new TreeNode(5);
        TreeNode l1= new TreeNode(3);
        l.left = l1;

        TreeNode r= new TreeNode(6);

        root1.left = l;
        root1.right = r;

        TreeNode root2 = new TreeNode(10);
        TreeNode l2= new TreeNode(5);
        TreeNode r2= new TreeNode(6);
        TreeNode r3= new TreeNode(2);

        r2.right = r3;
        root2.left = l2;
        root2.right = r2;


        mergeTrees(root1,root2);
    }

    @Test
    public void test2(){
        TreeNode root1 = null;
        TreeNode root2 = new TreeNode(10);

        root1 = mergeTrees(null,root2);
        Assert.assertNotNull(root1);
    }

    @Test
    public void test3(){
        TreeNode root1 = new TreeNode(10);
        TreeNode root2 = new TreeNode(10);

        TreeNode l = new TreeNode(3);
        TreeNode r = new TreeNode(4);

        root2.left = l;
        root2.right = r;


        root1 = mergeTrees(root1,root2);
        Assert.assertNotNull(root1);
    }

}

