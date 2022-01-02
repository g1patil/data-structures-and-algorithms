package trees.binary.leetcode;

import data.TreeNode;

/**
 * @author g1patil
 * 100. Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // if both are null then both are equal
        if ( p == null && q == null )
            return true;

        // if either is null, then unequal
        if ( p == null || q == null )
            return false;

        /* if the data is same then both sub tree should be equal , else unequal*/
        if (p.getVal() == q.getVal()){
            return isSameTree(p.left, q.left) &&
            isSameTree(p.right, q.right);
        } else return false;

    }
}
