package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * 99. Recover Binary Search Tree
 * Logic :
 *  Do inorder traversal on tree.
 *      Create previous pointer. This helps in tracking the previous node in the inorder.
 *      Create pointer first on the node which is greater than current node.
 *      Create second pointer on the current node which is greter than previous
 *      Swap the first and last node.
 *
 *      There  might be the case when only one node is in the wrong place,
 *      in that case , create the middle pointer. This middle pointer will point to
 *      next of first node.
 *
 *      Swap last or middle with the first node based on use case.
 */
@Platform(Site.LEETCODE)
@Quality(Stage.DOCUMENTED)
public class RecoverBinarySearchTree {

    TreeNode first;
    TreeNode last;
    TreeNode middle;
    TreeNode previous;

    /**
     * Inorder traversal of the node. Marks the node wrong node.
     * First will be the first node that is off and last will be the second node that is off.
     * If only one node is off then middle node will be marked which will be next of the first node.
     * @param root root node of the tree or subtree.
     * */
    private void inorder(TreeNode root){
        if (root == null)
            return;

        inorder(root.left);
        if(previous.getVal() > root.getVal()){
            if (first== null){
                first = previous;
                middle = root ;
            } else if (last== null){
                last = root;
            }
        }
        previous = root;
        inorder(root.right);
    }

    /**
     * Fixes the BT which has exactly two children in the wrong place.
     * */
    public void recoverTree(TreeNode root) {
        previous = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if (first!=null && last!= null){
            int temp = first.getVal();
            first.setVal(last.getVal());
            last.setVal(temp);
        } else if (first!=null && middle!= null){
            int temp = first.getVal();
            first.setVal(middle.getVal());
            middle.setVal(temp);
        }
    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(15);
        TreeNode n2 = new TreeNode(25);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(12);
        TreeNode n6 = new TreeNode(23);
        TreeNode n7 = new TreeNode(27);

        n1.setChild(n2, n3);
        n2.setChild(n4,n5);
        n3.setChild(n6 , n7);

        recoverTree(n1);

        System.out.println(first.toString());
        System.out.println(last.toString());
    }
}
