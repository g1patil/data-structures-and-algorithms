package trees.binary;

import data.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 543. Diameter of Binary Tree
 * Easy
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * */
public class DiameterBinaryTree {

    /**
     * @param node given node
     * @return height of the tree
     * */
    int getHeight(TreeNode node){
        if(node == null){
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if ( root == null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max( left + right + 2, Math.max( diameterOfBinaryTree( root.right), diameterOfBinaryTree( root.left)));
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

        node.setChild(n1,n2);
        n1.setChild(n3,n4);
        n2.setChild(n5,n6);
        n3.setChild(n7,null);
        n4.setChild(null,n8);

        Assert.assertEquals( 5 ,diameterOfBinaryTree(node));
    }
}
