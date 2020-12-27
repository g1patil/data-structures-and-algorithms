package trees.binary;

import data.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 101. Symmetric Tree - Easy
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * Follow up: Solve it both recursively and iteratively.
 *
 * */
public class SymmetricTree {

    boolean isSymmetric(final TreeNode node){

        if ( node.left !=null && node.right!=null){
            isSymmetric( node.left);
            isSymmetric( node.right);
        } else if ( node.left != null && node.right == null ){
            return false;
        } else if ( node.right != null && node.left == null ){
            return false;
        }
        return true;
    }

    //single node
    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(10);
        Assert.assertTrue(isSymmetric(treeNode));
    }

    @Test
    public void test2(){
        TreeNode treeNode = new TreeNode(10);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        treeNode.left = left ;
        treeNode.right = right ;

        Assert.assertTrue(isSymmetric(treeNode));
    }

    @Test
    public void test3(){
        TreeNode treeNode = new TreeNode(10);
        TreeNode left = new TreeNode(1);
        treeNode.left = left ;

        Assert.assertFalse(isSymmetric(treeNode));
    }
}
