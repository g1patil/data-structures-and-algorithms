package trees.binary;

import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * Given the root of the binary tree, return the BT with all leaves removed once.
 */
public class DeleteLeaves {

    private boolean isLeaf(TreeNode treeNode){
        return treeNode.left == null && treeNode.right == null ;
    }
    private TreeNode removeLeaves(TreeNode treeNode){
        if(treeNode == null)
            return treeNode;

        if (isLeaf(treeNode))
            return null;

        treeNode.left = removeLeaves(treeNode.left);
        treeNode.right = removeLeaves(treeNode.right);

        return treeNode;
    }

    @Test
    public void test_(){

        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(15);
        TreeNode n8 = new TreeNode(1);
        TreeNode n9 = new TreeNode(8);
        TreeNode n10 = new TreeNode(18);

        n2.setChild(n4,n5);
        n3.setChild(n6,n7);
        n5.setChild(n8,n9);
        n1.setChild(n2 , n3 );
        n9.setChild(null , n10);

        TreeNode.printTreeStatic(removeLeaves(n1));
    }
}
