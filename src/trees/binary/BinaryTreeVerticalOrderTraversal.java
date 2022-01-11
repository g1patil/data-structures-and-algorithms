package trees.binary;


import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jivanpatil
 * 314. Binary Tree Vertical Order Traversal
 * 987. Binary Tree Vertical Order Traversal
 *
 * Workig folution.
 * */
@Quality(value = Stage.INCOMPLETE , details = "f*** leetcode. Code passes in my local and gives the error in LC platform. At least this works")
@Platform(Site.LEETCODE)
public class BinaryTreeVerticalOrderTraversal {

    List<List<Integer>> listList = new ArrayList<>();
    int totalLists ;
    int startPosition;
    int _leftList = 0;
    int _rightList = 0 ;

    public void calculateNumberOfLists(TreeNode treeNode  , int _number){

        if (treeNode == null)
            return;

        calculateNumberOfLists(treeNode.left , _number - 1);
        _leftList = Math.min(_number , _leftList);
        _rightList = Math.max(_number , _rightList);
        calculateNumberOfLists(treeNode.right , _number +  1);

    }

    public void verticalOrderHelper(TreeNode root , int listNumber) {
        if (root == null || listNumber < 0 || listNumber >= listList.size())
            return;

        listList.get(listNumber).add(root.val);
        verticalOrderHelper(root.left , listNumber -1);
        verticalOrderHelper(root.right , listNumber  + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        calculateNumberOfLists(root, 0);
        totalLists = -_leftList + 1 + _rightList;
        startPosition = - _leftList ;
        for (int i = 1; i <= totalLists ; i++) {
            listList.add(new ArrayList<>());
        }
        verticalOrderHelper(root , startPosition);
        if (listList.get(listList.size()-1).isEmpty())
            listList.remove(listList.size()-1);
        for (List l : listList)
            Collections.sort(l);
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

        System.out.println(verticalTraversal(root));
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

        System.out.println(verticalTraversal(root));
    }

    @Test
    public void test3(){
        TreeNode root = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n4 = new TreeNode(4);

//        root.setChild(n4,n9);
        System.out.println(verticalTraversal(root));
    }

    @Test
    public void test4(){
        TreeNode root = new TreeNode(0);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        root.setChild(n2,n1);
        n2.setChild(null,n4);
        n1.setChild(null,n3);

//        root.setChild(n4,n9);
        System.out.println(verticalTraversal(root));
    }
}