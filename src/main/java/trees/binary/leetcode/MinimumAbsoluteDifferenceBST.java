package trees.binary.leetcode;

import model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther g1patil
 */
public class MinimumAbsoluteDifferenceBST {

    List<Integer> integerList = new ArrayList<>();

    public List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null)
            return integerList;
        inOrderTraversal(root.left);
        integerList.add(root.getVal());
        inOrderTraversal(root.right);

        return integerList;
    }

    public int getMinimumDifference(TreeNode treeNode){
        integerList = inOrderTraversal(treeNode);
        int previous = integerList.get(0);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < integerList.size(); i++) {
            result = Math.min( result , integerList.get(i) -  previous);
            previous = integerList.get(i) ;
        }

        return result;
    }

    @Test
    public void test2(){

        TreeNode n1 = new TreeNode(50);
        TreeNode n2 = new TreeNode(25);
        TreeNode n3 = new TreeNode(75);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(35);
        TreeNode n6 = new TreeNode(60);
        TreeNode n7 = new TreeNode(90);
        TreeNode n8 = new TreeNode(51);
        TreeNode n9 = new TreeNode(65);

        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n3.setChild(n6,n7);
        n6.setChild(n8,n9);

        Assertions.assertEquals( 1 ,getMinimumDifference(n1));
    }
}
