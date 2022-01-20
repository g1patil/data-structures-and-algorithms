package trees.binary;

import annotation.Platform;
import annotation.Site;
import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 298. Binary Tree Longest Consecutive Sequence
 */
@Platform(Site.LEETCODE)
public class BinaryTreeLongestConsecutiveSequence {

    public int longestConsecutive(TreeNode root) {
        return longestConsecutiveHelper(root , Integer.MIN_VALUE);
    }

    private int longestConsecutiveHelper(TreeNode root, int minValue) {
        if (root == null)
            return 0;

        if (minValue + 1 == root.val ){
            return 1 + Math.max(
                    longestConsecutiveHelper(root.left , root.val) ,
                    longestConsecutiveHelper(root.right , root.val)
            );
        }

        return Math.max(
                longestConsecutiveHelper(root.left , root.val) ,
                longestConsecutiveHelper(root.right , root.val)
        );
    }

    @Test
    public void test_(){
        TreeNode root  = new TreeNode(1);
        TreeNode n3  = new TreeNode(3);
        TreeNode n2  = new TreeNode(2);
        TreeNode n4  = new TreeNode(4);
        TreeNode n5  = new TreeNode(5);

        root.setChild(null, n3);
        n3.setChild(n2,n4);
        n4.setChild(null , n5);
        System.out.println(longestConsecutive(root));
    }
}
