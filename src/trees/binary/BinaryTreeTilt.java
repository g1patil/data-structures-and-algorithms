package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 563. Binary Tree Tilt
 * */
@Quality(Stage.BUGGY)
@Platform(Site.LEETCODE)
public class BinaryTreeTilt {

    public int findTilt(TreeNode root) {
        TreeNode treeNode = new TreeNode(0);
        findTiltHelper(root,treeNode);
        return treeNode.val;
    }

    private void findTiltHelper(TreeNode root, TreeNode treeNode) {
        if (root == null)
            return;

        int left = root.left == null ? 0 : root.left.val;
        int right = root.right == null ? 0 : root.right.val;
        treeNode.val +=Math.abs(left-right);

        findTiltHelper(root.left,treeNode);
        findTiltHelper(root.right,treeNode);

    }

    @Test
    public void test(){
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n9 = new TreeNode(9);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        n4.setChild(n2,n9);
        n2.setChild(n3,n5);
        n9.setChild(null,n7);
        System.out.println(findTilt(n4));
    }
}
