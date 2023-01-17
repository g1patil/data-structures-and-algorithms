package trees.binary.leetcode;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * link : https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
 * */
@Quality(Stage.FAILING)
@Platform(Site.LEETCODE)
public class CheckStringIsValidSequencefromRoottoLeavesPathinBinaryTree {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i);

        return isValidSequenceHelper(root , "" , sb.toString() );
    }

    private boolean isValidSequenceHelper(TreeNode root, String s, String expected) {
        if (expected.equals(s) && root == null)
            return true;

        if (root == null)
            return false;

        return isValidSequenceHelper(root.left , s + root.val, expected) ||
         isValidSequenceHelper(root.right , s + root.val, expected) ;
    }

    @Test
    public void test(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n2.setChild(n1,n3);
        n4.setChild(n2,n6);
        n6.setChild(n5,n7);

        Assertions.assertTrue(isValidSequence(n4 , new int[]{4,2,1}));
    }

    @Test
    public void test2(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n2.setChild(n1,n3);
        n4.setChild(null,n6);
        n6.setChild(n5,n7);

        Assertions.assertTrue(isValidSequence(n4 , new int[]{4}));
    }


}
