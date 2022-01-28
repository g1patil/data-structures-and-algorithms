package dynamicprogramming;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 337. House Robber III
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class HouseRobber3 {

    private static final int INCLUDE = 0,EXCLUDE = 1;

    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robHelper(TreeNode root ) {
        if (root == null)
            return new int[2];

        int[] leftResult = robHelper(root.left);
        int[] rightResult = robHelper(root.right);

        int[] rootResult = new int[2];

        rootResult[INCLUDE] = root.val + leftResult[EXCLUDE] + rightResult[EXCLUDE];
        rootResult[EXCLUDE] = Math.max(leftResult[INCLUDE], leftResult[EXCLUDE]) +
                Math.max(rightResult[INCLUDE], rightResult[EXCLUDE]);

        return rootResult;
    }


    @Test
    public void test_(){
        TreeNode root= new TreeNode(10);
        TreeNode n1= new TreeNode(20);
        TreeNode n2= new TreeNode(100);
        TreeNode n3= new TreeNode(100);
        TreeNode n4= new TreeNode(3);
        TreeNode n5= new TreeNode(1);

        root.setChild(n1,n2);
        n1.setChild(n3,null);
//        n2.setChild(null,n5);
        System.out.println(rob(root));
    }
}
