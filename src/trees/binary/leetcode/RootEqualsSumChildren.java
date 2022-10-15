package trees.binary.leetcode;

import annotation.Platform;
import annotation.Site;
import model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 2236. Root Equals Sum of Children
 * Seriously no idea why LC addeed this
 * */
@Platform(Site.LEETCODE)
public class RootEqualsSumChildren {

    /**
     * Returns true/false if the sum of the
     * left + right child is equal to root
     * */
    public boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }

    public boolean checkTreeV2(TreeNode root) {
        final int leftVal = root.left == null ? 0 : root.left.val;
        final int rightVal = root.right == null ? 0 : root.right.val;
        return root.val == (leftVal + rightVal);
    }

    @Test
    @DisplayName("first test")
    public void test(){
        TreeNode root = new TreeNode(10);
        root.setChild(new TreeNode(4),new TreeNode(6));
        Assertions.assertTrue(checkTree(root));
    }

    @Test
    @DisplayName("first test")
    public void test2(){
        TreeNode root = new TreeNode(101);
        root.setChild(new TreeNode(4),new TreeNode(6));
        Assertions.assertFalse(checkTree(root));
    }

    @Test
    public void test3(){
        TreeNode root = new TreeNode(10);
        root.setChild(new TreeNode(5),null);
        Assertions.assertFalse(checkTreeV2(root));
    }

    @Test
    public void test4(){
        TreeNode root = new TreeNode(10);
        root.setChild(new TreeNode(10),null);
        Assertions.assertTrue(checkTreeV2(root));
    }
}
