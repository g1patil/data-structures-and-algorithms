package trees.binary.leetcode;

import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 938. Range Sum of BST
 * Given the two range, high and low, return the sum of all
 * the nodes in that range.
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0 ;

        if ( root.getVal() <= high && root.getVal() >= low){
            return root.getVal() + rangeSumBST(root.left , low , high) + rangeSumBST(root.right , low, high);
        } else return rangeSumBST(root.left , low , high) + rangeSumBST(root.right , low, high);

    }
    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        n1.setChild(n2,n3);
        System.out.println(rangeSumBST(n1 , 4,17));

    }

}
