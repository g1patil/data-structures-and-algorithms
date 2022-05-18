package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;

/**
 * 404. Sum of Left Leaves
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SumofLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root , false);
    }

    private int sumOfLeftLeavesHelper(TreeNode root, boolean left){

        if(root == null)
            return 0;

        if(root.left == null && root.right == null && left)
            return root.val;

        return sumOfLeftLeavesHelper(root.left , true) +
                sumOfLeftLeavesHelper(root.right , false);
    }
}
