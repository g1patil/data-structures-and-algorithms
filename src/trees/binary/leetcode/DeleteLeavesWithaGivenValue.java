package trees.binary.leetcode;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 1325. Delete Leaves With a Given Value
 * Given a binary tree root and an integer target,
 * delete all the leaf nodes with value target.
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class DeleteLeavesWithaGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeLeafNodesHelper(root,target);
    }

    private TreeNode removeLeafNodesHelper(TreeNode root, int target) {
        if (root == null)
            return root;

        if (isLeafNode(root) && root.val == target)
            return null;

        root.left = removeLeafNodesHelper(root.left , target);
        root.right = removeLeafNodesHelper(root.right , target);

        return root.val == target && isLeafNode(root) ? null : root;
    }

    private boolean isLeafNode(final TreeNode node){
        return node !=null && ( node.left == null && node.right == null);
    }

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = null;
        TreeNode t6 = new TreeNode(2);
        TreeNode t7 = new TreeNode(4);

        t1.setChild( t2, t3);
        t2.setChild(t4,t5);
        t3.setChild(t6,t7);

        TreeNode.printTreeStatic(removeLeafNodes(t1, 2 ));
    }
}
