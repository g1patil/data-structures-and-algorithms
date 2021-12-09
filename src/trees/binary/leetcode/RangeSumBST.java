package trees.binary;

import data.TreeNode;
import org.junit.Test;

/**
 * @auther g1patil
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0 ;

        if ( root.getData() <= high && root.getData() >= low){
            return root.getData() + rangeSumBST(root.left , low , high) + rangeSumBST(root.right , low, high);
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
