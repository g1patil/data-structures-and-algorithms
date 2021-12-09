package trees.binary.leetcode;

import data.TreeNode;
import org.junit.Test;

/**
 * @auther g1patil
 */
public class SumBST {

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        n1.setChild(n2,n3);

        TreeNode m1 = new TreeNode(10);
        TreeNode m2 = new TreeNode(5);
        TreeNode m3 = new TreeNode(15);
        m1.setChild(m2,m3);
        sumBST(n1, m1).printTree(n1);
    }

    @Test
    public void test_2(){
        TreeNode n1 = new TreeNode(10);
        TreeNode m1 = new TreeNode(10);

        sumBST(n1, m1).printTree(n1);
    }

    @Test
    public void test_3(){
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        n1.setChild(null,n2);

        TreeNode m1 = new TreeNode(10);
        TreeNode m2 = new TreeNode(5);

        m1.setChild(null, m2);
        sumBST(n1, m1).printTree(n1);
    }

    @Test
    public void test_4(){
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        n1.setChild(null,n2);

        TreeNode m1 = new TreeNode(10);
        TreeNode m2 = new TreeNode(5);
        TreeNode m3 = new TreeNode(6);

        m1.setChild(m2, null);
        m2.setChild(null, m3);
        sumBST(n1, m1).printTree(n1);
    }

    private TreeNode sumBST(TreeNode n1, TreeNode m1) {
        if (n1 == null)
            return m1;

        if (m1 == null)
            return n1;

        n1.setData( n1.getData() + m1.getData());
        n1.left = sumBST(n1.left, m1.left);
        n1.right = sumBST(n1.right, m1.right);
        return n1;
    }
}
