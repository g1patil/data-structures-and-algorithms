package trees.binary;

import annotation.Platform;
import annotation.Site;
import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 298. Binary Tree Longest Consecutive Sequence
 */
@Platform(Site.LEETCODE)
public class BinaryTreeLongestConsecutiveSequence {

    public int longestConsecutive(TreeNode root) {
        return longestConsecutiveHelper(root , root ,0 );
    }

    private int longestConsecutiveHelper(TreeNode root, TreeNode parent , int length) {
        if (root == null)
            return length;

        length = (parent != null && root.val + 1 == parent.val) ? length + 1 : 1 ;

        return Math.max( length , Math.max(
                longestConsecutiveHelper(root.left , root , length) ,
                longestConsecutiveHelper(root.right , root ,length )
                )
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
