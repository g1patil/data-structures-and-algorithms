package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any TreeNode sequence from some
 * starting TreeNode to any TreeNode in the tree along the parent-child connections.
 * The path must contain at least one TreeNode and does not need to go through the root.
 * */
@Quality(value = Stage.DOCUMENTED , details = "passes all test cases")
@Platform(Site.LEETCODE)
public class BinaryTreeMaximumPathSum {
    

    /**
     * Given the TreeNode, gets the sum of the diameter. Here diameter will be considered as the largest sum
     * @param root given TreeNode
     * @return returns the sum of the maximum path
     *
     * */

    int some = Integer.MIN_VALUE;
    private int maxPathSum(TreeNode root) {

        if(root == null){
            return 0;
        }
        int leftSum = Math.max(maxPathSum(root.left) , 0) ;
        int rightSum = Math.max(maxPathSum(root.right ) , 0 ) ;

        some = Math.max( some , root.getVal() + leftSum + rightSum);
        return root.getVal() + Math.max(leftSum , rightSum);
    }

    private int maxPathSumDriver(TreeNode root){
        maxPathSum(root);
        return some;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(30);
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(-20);
        root.setChild(n1,n2);

        Assertions.assertEquals(40,maxPathSumDriver(root));
    }

    @Test
    public void test2(){
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(6);

        root.left = n1;
        root.right = n2;

        Assertions.assertEquals(21,maxPathSumDriver(root));
    }

    @Test
    public void test3(){
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(6);

        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(12);

        root.left = n1;
        root.right = n2;

        n2.left = n3;
        n2.right = n4;

        Assertions.assertEquals(33,maxPathSumDriver(root));
    }

    @Test
    public void test4(){
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(6);

        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(12);

        TreeNode n5 = new TreeNode(100);
        TreeNode n6 = new TreeNode(200);

        root.left = n1;
        root.right = n2;

        n2.left = n3;
        n2.right = n4;

        n1.left = n5;
        n1.right = n6;

        Assertions.assertEquals(305,maxPathSumDriver(root));
    }


    @Test
    public void test5(){
        TreeNode root = new TreeNode(-2);
        Assertions.assertEquals(-2,maxPathSumDriver(root));
    }
}
