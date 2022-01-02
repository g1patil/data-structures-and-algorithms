package trees.binary.leetcode;

import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @auther g1patil
 */
public class CountGoodNodesBinaryTree {

    private int counter = 0;

    private int goodNodeHelper(TreeNode treeNode , int max){
        if (treeNode == null)
            return counter;

        if ( treeNode.getVal() >= max){
            counter+=1;
            max = treeNode.getVal();
        }

        goodNodeHelper(treeNode.left , max);
        goodNodeHelper(treeNode.right , max);

        return counter;
    }
    public int goodNodes(TreeNode root) {
        return goodNodeHelper(root , Integer.MIN_VALUE);
    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(5);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);

        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n3.setChild(n6,n7);
        n5.setChild(n8, null);
        n6.setChild(n9 , null );
        System.out.println(goodNodes(n1));
    }
}
