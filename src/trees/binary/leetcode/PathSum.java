package trees.binary.leetcode;

import model.TreeNode;

/**
 * @author g1patil
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if ( root == null && targetSum == 0)
            return true;
        if ( root == null && targetSum > 0)
            return false;

        return hasPathSum( root.left ,targetSum - root.getVal() )
                || hasPathSum(root.right , targetSum - root.getVal() );
    }
}
