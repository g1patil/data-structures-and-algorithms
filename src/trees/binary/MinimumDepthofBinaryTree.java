package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 111. Minimum Depth of Binary Tree
 */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left==null && root.right!=null){
            return 1 +  Math.min(Integer.MAX_VALUE ,minDepth(root.right));
        } else if(root.right==null && root.left!=null){
            return 1 +  Math.min(Integer.MAX_VALUE ,minDepth(root.left));
        } else return 1 + Math.min(minDepth(root.left) ,minDepth(root.right));
    }

    @Test
    public void test_(){
        TreeNode root  = new TreeNode(1);
        TreeNode n1  = new TreeNode(2);
        TreeNode n2  = new TreeNode(3);
        root.setChild(n1,n2);
        System.out.println(minDepth(root));
    }

    @Test
    public void test_2(){
        TreeNode root  = new TreeNode(1);
        TreeNode n1  = new TreeNode(2);
        TreeNode n2  = new TreeNode(3);

        TreeNode n5  = new TreeNode(6);
        TreeNode n6  = new TreeNode(7);
        root.setChild(n1,n2);
        n2.setChild(n5,n6);
        System.out.println(minDepth(root));
    }

    @Test
    public void test_3(){

        TreeNode n1  = new TreeNode(2);
        TreeNode n2  = new TreeNode(3);
        TreeNode n3  = new TreeNode(4);
        TreeNode n4  = new TreeNode(5);
        TreeNode n5  = new TreeNode(6);
        n1.setChild(null,n2);
        n2.setChild(null , n3);
        n3.setChild(null , n4);
        n4.setChild(null , n5);
        System.out.println(minDepth(n1));
    }
}
