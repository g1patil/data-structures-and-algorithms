package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 114. Flatten Binary Tree to Linked List
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        if (root.left !=null){
            TreeNode temp = root.right;
            addToRight(root.left , temp);
            root.right = root.left;
            root.left = null;
        }
    }

    public void addToRight(TreeNode left , TreeNode right){
        TreeNode temp = left;
        while (temp.right!=null)
            temp = temp.right;
        temp.right = right;
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        root.setChild(n3,n7);
        n3.setChild(n1,n4);
        n7.setChild(n6,n8);
        flatten(root);
        TreeNode.printTreeStatic(root);
    }

    @Test
    public void test_2(){
        TreeNode root = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        root.setChild(null,n3);

        flatten(root);
        TreeNode.printTreeStatic(root);
    }
}
