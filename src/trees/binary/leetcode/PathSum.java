package trees.binary.leetcode;

import data.TreeNode;

/**
 * @auther g1patil
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if ( root == null && targetSum == 0)
            return true;
        if ( root == null && targetSum > 0)
            return false;

        return hasPathSum( root.left ,targetSum - root.getData() )
                || hasPathSum(root.right , targetSum - root.getData() );
    }
}
