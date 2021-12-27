package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 687. Longest Univalue Path
 */
@Platform(Site.LEETCODE)
@Quality(value = Stage.TESTED)
public class LongestUnivaluePath {

    int max_length = 0;

    public int driver(TreeNode treeNode){
        longestUnivaluePath(treeNode);
        return max_length;
    }
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;

        int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);

        int leftLength = 0;
        int rightLength = 0;
        if (root.left != null && root.getData() == root.left.getData())
            leftLength = left + 1 ;

        if (root.right != null && root.getData() == root.right.getData())
            rightLength = right + 1;

        max_length = Math.max( leftLength + rightLength, max_length);
        return Math.max( leftLength , rightLength);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(10);
        TreeNode n3 = new TreeNode(10);
//        TreeNode n4 = new TreeNode(5);
        root.setChild(n1, n2);
        n1.setChild(n3 , null);
//        n2.setChild(null , n4 );
        System.out.println(driver(root));
    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(0);

        TreeNode n8 = new TreeNode(0);
        TreeNode n9 = new TreeNode(2);
        TreeNode n10 = new TreeNode(2);
        TreeNode n11 = new TreeNode(7);
        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n3.setChild(n6,n7);
        n5.setChild(n8,n9);
        n9.setChild(n10 , n11);

        System.out.println(longestUnivaluePath(n1  ));
    }

    @Test
    public void test_2(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(1);
        TreeNode n8 = new TreeNode(1);

        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n3.setChild(n6,n7);
        n7.setChild(null , n8);


        System.out.println(longestUnivaluePath(n1  ));
    }

    @Test
    @DisplayName("TODO this should return 4 ")
    public void test_3(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);
        TreeNode n8 = new TreeNode(1);
        n1.setChild(null,n3);
        n3.setChild(n4,n5);
        n4.setChild(n6,n7);
        n5.setChild(n8,null);

        System.out.println(longestUnivaluePath(n1 ));
    }

}
