package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;

/**
 * @author g1patil
 * 1644. Lowest Common Ancestor of a Binary Tree II
 *
 * Diff with 235/236 : is that either node can be missing from the tree
 * For that we need to traverse first and then do the computation
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LCABT2 {

    int foundCount = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestorHelper(root , p , q );
        return foundCount == 2 ? lca : null;
    }

    public TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return root;

        /* traverse first */
        TreeNode left = lowestCommonAncestorHelper(root.left , p , q);
        TreeNode right = lowestCommonAncestorHelper(root.right , p , q );

        /* compute the answer */
        if(root == p){
            foundCount++;
            return root;
        }

        if(root == q){
            foundCount++;
            return root;
        }

        return left == null ? right : right == null ? left : root;

    }
}
