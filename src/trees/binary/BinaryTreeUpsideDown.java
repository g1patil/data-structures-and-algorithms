package trees.binary;


import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;
import trees.Tree;

/**
 * 156. Binary Tree Upside Down
 *
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class BinaryTreeUpsideDown {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode newRoot = getNewRoot(root);
        upsideDownBinaryTreeHelper(root);
        return newRoot;
    }

    private TreeNode getNewRoot(TreeNode root) {
        TreeNode tempRoot = root;
        while (tempRoot!=null){
            if (tempRoot.left!=null)
                tempRoot=tempRoot.left;
            if (tempRoot.left == null)
                break;
        }
        return tempRoot;
    }

    private void upsideDownBinaryTreeHelper(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;

        upsideDownBinaryTreeHelper(root.left);
        tranformNode(root);
        upsideDownBinaryTreeHelper(root.right);
    }

    private void tranformNode(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        left.right = root;
        left.left = right;

        root.left = null;
        root.right = null;
    }

    @Test
    public void test(){
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(30);
        TreeNode n4 = new TreeNode(40);
        TreeNode n5 = new TreeNode(50);
        TreeNode n6 = new TreeNode(60);
        TreeNode n7 = new TreeNode(70);
        TreeNode n8 = new TreeNode(80);

        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        upsideDownBinaryTree(n1);
    }
}
