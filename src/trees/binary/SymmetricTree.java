package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root , root);
    }

    public boolean isMirror(TreeNode l,TreeNode r){
        if( l == null && r == null)
            return true;
        if( l == null || r == null)
            return false;
        return l.val == r.val && isMirror(l.left , r.right) && isMirror(l.right , r.left);
    }

    //single node
    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(10);
        Assertions.assertTrue(isSymmetric(treeNode));
    }

    @Test
    public void test2(){
        TreeNode treeNode = new TreeNode(10);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        treeNode.left = left ;
        treeNode.right = right ;

        Assertions.assertTrue(isSymmetric(treeNode));
    }

    @Test
    public void test3(){
        TreeNode treeNode = new TreeNode(10);
        TreeNode left = new TreeNode(1);
        treeNode.left = left ;

        Assertions.assertFalse(isSymmetric(treeNode));
    }
}
