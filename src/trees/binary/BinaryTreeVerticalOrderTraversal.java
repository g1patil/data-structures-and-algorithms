package trees.binary;


import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jivanpatil
 * 314. Binary Tree Vertical Order Traversal
 *
 * Workig folution.
 * */
@Quality(value = Stage.INCOMPLETE , details = "f*** leetcode. Code passes in my local and gives the error in LC platform. At least this works")
@Platform(Site.LEETCODE)
public class BinaryTreeVerticalOrderTraversal {

    List<List<Integer>> listList = new ArrayList<>();
    int totalLists ;
    int startPosition;

    public void calculateNumberOfLists(TreeNode treeNode){
        int result = 0;
        if (treeNode!= null)
            result++;
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;

        int _left=0;
        while (left != null){
            result++;
            left = left.left;
            _left++;
        }

        int _right=0;
        while (right != null){
            result++;
            right = right.left;
            _right++;
        }

        for (int i = 1; i <= result ; i++) {
            listList.add(new ArrayList<>());
        }
        startPosition = _left ;
        totalLists = result;

    }

    public void verticalOrderHelper(TreeNode root , int listNumber) {
        if (root == null || listNumber < 0 || listNumber >= listList.size())
            return;

        listList.get(listNumber).add(root.val);
        verticalOrderHelper(root.left , listNumber -1);
        verticalOrderHelper(root.right , listNumber  + 1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        calculateNumberOfLists(root);
        verticalOrderHelper(root , startPosition);
        if (listList.get(listList.size()-1).isEmpty())
            listList.remove(listList.size()-1);
        return listList;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        root.setChild(n9, n20);
        n20.setChild(n15,n7);

        System.out.println(verticalOrder(root));
    }

    @Test
    public void test2(){
        TreeNode root = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n4 = new TreeNode(4);
        TreeNode n0 = new TreeNode(0);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n9.setChild(n4,n0);
        n0.setChild(n5,null);
        root.setChild(n9,n8);
        n8.setChild(n1,n7);
        n1.setChild(null,n2);

        System.out.println(verticalOrder(root));
    }

    @Test
    public void test3(){
        TreeNode root = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n4 = new TreeNode(4);

//        root.setChild(n4,n9);
        System.out.println(verticalOrder(root));
    }
}
