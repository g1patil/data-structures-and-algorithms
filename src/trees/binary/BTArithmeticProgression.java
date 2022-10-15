package trees.binary;

import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class BTArithmeticProgression {

    public int getAP(TreeNode root){
        return getAPHelperIncreasing(root , Integer.MIN_VALUE);
    }

    private int getAPHelperIncreasing(TreeNode root, int previous) {
        if (root == null)
            return 0;

        if (root.val > previous){
            return 1 + Math.max( getAPHelperIncreasing(root.left , root.val), getAPHelperIncreasing(root.right , root.val) );
        }

        return getAPHelperIncreasing(root , Integer.MIN_VALUE);
    }

    private int getAPHelperDecreasing(TreeNode root, int previous) {
        if (root == null)
            return 0;

        if (root.val < previous){
            return 1 + Math.max( getAPHelperIncreasing(root.left , root.val), getAPHelperIncreasing(root.right , root.val) );
        }

        return getAPHelperIncreasing(root , Integer.MIN_VALUE);
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(6);
        TreeNode n9 = new TreeNode(9);
        TreeNode n7 = new TreeNode(7);
        TreeNode n12 = new TreeNode(12);
        TreeNode n15 = new TreeNode(15);


        root.setChild(null,n9);
        n9.setChild(n7,n12);
        n12.setChild(null,n15);

        System.out.println(getAP(root));
    }

    @Test
    public void test_2(){
        TreeNode root = new TreeNode(6);
        TreeNode n9 = new TreeNode(9);
        root.setChild(null,n9);

        System.out.println(getAP(root));
    }
}
