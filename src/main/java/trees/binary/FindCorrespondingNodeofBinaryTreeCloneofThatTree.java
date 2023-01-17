package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class FindCorrespondingNodeofBinaryTreeCloneofThatTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return getTargetCopyHelper(original,cloned,target);
    }

    public final TreeNode getTargetCopyHelper(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null)
            return null;

        TreeNode left =  getTargetCopyHelper(original.left , cloned.left , target);
        if(original == target)
            return cloned;
        TreeNode right =  getTargetCopyHelper(original.right , cloned.right , target);

        return left == null ? right : left;
    }
}
