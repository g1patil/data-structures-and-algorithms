package dynamicprogramming;

import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class HouseRobber3 {

    enum Include {
        INCLUDE,
        EXCLUDE
    }

    public int rob(TreeNode root) {
        return Math.max(robHelper(root , Include.INCLUDE ) , robHelper(root , Include.EXCLUDE));
    }

    private int robHelper(TreeNode root , Include rootInclude ) {
        if (root == null)
            return 0 ;

        if (root.left == null && root.right == null && rootInclude == Include.EXCLUDE)
            return root.val;

        if (root.left == null && root.right == null && rootInclude == Include.INCLUDE)
            return 0;

        if (rootInclude == Include.INCLUDE){
            return robHelper(root.left , Include.EXCLUDE) + robHelper(root.right , Include.EXCLUDE);
        } else {
            return root.val + robHelper(root.left , Include.INCLUDE) + robHelper(root.right , Include.INCLUDE);
        }
    }

    @Test
    public void test_(){
        TreeNode root= new TreeNode(3);
        TreeNode n1= new TreeNode(4);
        TreeNode n2= new TreeNode(5);
        TreeNode n3= new TreeNode(1);
        TreeNode n4= new TreeNode(3);
        TreeNode n5= new TreeNode(1);

        root.setChild(n1,n2);
        n1.setChild(n3,n4);
        n2.setChild(null,n5);
        System.out.println(rob(root));
    }
}
