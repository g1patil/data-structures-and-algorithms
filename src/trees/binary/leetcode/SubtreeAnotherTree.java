package trees.binary.leetcode;

import model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * Answer reference : https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 */
public class SubtreeAnotherTree {

    private boolean areSame(TreeNode root, TreeNode subRoot){
        if( root == null && subRoot == null)
            return true;

        if( root == null || subRoot == null)
            return false;

        if ( root.getVal() != subRoot.getVal())
            return false;

        return (root.getVal() == subRoot.getVal()) &&
                areSame(root.left , subRoot.left) &&
                areSame(root.right , subRoot.right) ;

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if( subRoot == null)
            return true;

        if (root == null)
            return false;

        if (areSame(root , subRoot))
            return true;

        return isSubtree(root.left , subRoot) ||
                isSubtree(root.right , subRoot);

    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n3.setChild(n4,n5);
        n4.setChild(n1,n2);
        n2.setChild(new TreeNode(0), null);

        TreeNode m4 = new TreeNode(4);
        TreeNode m1 = new TreeNode(1);
        TreeNode m2 = new TreeNode(2);
        m4.setChild(m1,m2);

        Assertions.assertFalse( isSubtree(n3 , m4 ));
    }
}
