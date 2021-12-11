package trees.binary;

import data.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *226. Invert Binary Tree
 *
 * nvert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can’t invert a binary tree on a whiteboard so f*** off.
 *
 * */
public class InvertBinaryTree {

    /**
     * @param node given node
     * */
    public TreeNode invertTree(TreeNode node) {
        if( node == null){
            return node;
        }

        TreeNode temp = node.left;
        node.left = node.right ;
        node.right = temp;

        invertTree(node.left);
        invertTree(node.right);

        return node;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(10);
        invertTree(root);
    }

    @Test
    public void test2(){
        TreeNode root = new TreeNode(10);
        TreeNode l = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);

        l.setChild(n4,n6);

        TreeNode r = new TreeNode(15);
        TreeNode r2 = new TreeNode(20);

        r.setChild(null,r2);

        root.setChild(l,r);
        root = invertTree(root);
        Assertions.assertEquals(root.left,r);
        Assertions.assertEquals(root.right,l);
    }
}
