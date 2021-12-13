package trees.binary.leetcode;

import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 *
 * 366. Find Leaves of Binary Tree
 * Current approch O(n log n )
 *
 */
public class FindLeavesBinaryTree {

    List<Integer> integerArrayList ;
    List<List<Integer>> listList = new ArrayList<>();


    private boolean isLeaf(TreeNode treeNode){
        return treeNode.left == null && treeNode.right == null ;
    }
    private TreeNode removeLeaves(TreeNode treeNode){
        if(treeNode == null)
            return treeNode;

        if (isLeaf(treeNode)){
            integerArrayList.add(treeNode.getData());
            return null;
        }

        treeNode.left = removeLeaves(treeNode.left);
        treeNode.right = removeLeaves(treeNode.right);

        return treeNode;
    }

    @Test
    public void test_(){

        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(15);
        TreeNode n8 = new TreeNode(1);
        TreeNode n9 = new TreeNode(8);
        TreeNode n10 = new TreeNode(18);

        n2.setChild(n4,n5);
        n3.setChild(n6,n7);
        n5.setChild(n8,n9);
        n1.setChild(n2 , n3 );
        n9.setChild(null , n10);

        while (n1 != null){
            integerArrayList = new ArrayList<>();
            n1 = removeLeaves(n1);
            listList.add(integerArrayList);
        }

        System.out.println(listList);
    }

}
