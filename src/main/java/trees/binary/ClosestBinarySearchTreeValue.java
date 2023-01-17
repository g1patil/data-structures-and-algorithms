package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;

/**
 * @author g1patil
 * 270. Closest Binary Search Tree Value
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ClosestBinarySearchTreeValue {

    double diff = Integer.MAX_VALUE;
    int result;

    public int closestValue(TreeNode root, double target) {
        closestValueHelper(root , target);
        return result;
    }

    public void closestValueHelper(TreeNode root, double target){
        if (root == null)
            return;

        double tempDiff = Math.abs(root.val - target);
        if (tempDiff < diff){
            diff = tempDiff;
            result = root.val;
        }
        closestValueHelper(root.left , target);
        closestValueHelper(root.right , target);
    }
}
