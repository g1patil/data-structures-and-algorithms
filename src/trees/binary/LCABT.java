package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;

/**
 * @author g1patil
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LCABT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);

        if(left != null && right != null)
            return root;

        if(left == null)
            return right;
        else return left;
    }
}
