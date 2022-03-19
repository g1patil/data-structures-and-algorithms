package dynamicprogramming.knapsack;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author g1patil
 * Largest Independent Set Problem | DP-26
 *
 * Actual problem asks for largest independent set size.
 * I have implemented sum of all those children. To get the size of the subset ,
 * replace the line 44 where we add the val of the node, instead choose 1 as the count.
 */
@Platform(Site.GEEKFORGEEKS)
@Quality(value = Stage.FAILING, details = "passes 122/124 cases on LC")
/* Slower , needs improvements*/
public class LargestIndependentSetBST {

    Map<TreeNode , Integer> treeNodeIntegerMap = new HashMap<>();

    private int getNumberOfNodes(TreeNode treeNode){
        if (treeNode == null)
            return 0;

        return 1 + getNumberOfNodes(treeNode.left) + getNumberOfNodes(treeNode.right);
    }

    private boolean canChoose(List<TreeNode> treeNodeList , TreeNode currentNode){
        if (treeNodeList.isEmpty())
            return true;
        for (TreeNode node : treeNodeList){
            if (node.left != null && node.left == currentNode ){
                return false;
            } else if (node.right != null && node.right == currentNode)
                return false;
        }
        return true;
    }

    private int getLIS(TreeNode treeNode , List<TreeNode> treeNodeList){
        if (treeNode == null)
            return 0;

        if (canChoose(treeNodeList , treeNode)){
            List<TreeNode> newTreeNodeList = new LinkedList<>();
            newTreeNodeList.addAll(treeNodeList);
            newTreeNodeList.add(treeNode);
            return Math.max(
                    1 + getLIS(treeNode.left , newTreeNodeList) + getLIS(treeNode.right , newTreeNodeList),
                    getLIS(treeNode.left , treeNodeList) + getLIS(treeNode.right , treeNodeList)
            );
        }
        return getLIS(treeNode.left , treeNodeList) + getLIS(treeNode.right , treeNodeList);
    }
    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(30);
        TreeNode n4 = new TreeNode(40);
        TreeNode n5 = new TreeNode(50);
        TreeNode n6 = new TreeNode(60);
        TreeNode n7 = new TreeNode(70);
        TreeNode n8 = new TreeNode(80);

        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n5.setChild(n7,n8);
        n3.setChild(null , n6);
        List<TreeNode> newTreeNodeList = new LinkedList<>();
        System.out.println(getLIS(n1 , newTreeNodeList));
    }

    @Test
    public void test_2(){
        TreeNode n1 = new TreeNode(-10);
        TreeNode n2 = new TreeNode(-20);
        TreeNode n3 = new TreeNode(-30);
        TreeNode n4 = new TreeNode(-40);
        TreeNode n5 = new TreeNode(-50);
        TreeNode n6 = new TreeNode(10);
        TreeNode n7 = new TreeNode(70);
        TreeNode n8 = new TreeNode(-80);
        TreeNode n9 = new TreeNode(-80);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(20);

        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n5.setChild(n7,n8);
        n3.setChild(null , n6);
        n8.setChild(null , n9);
        n9.setChild(n10,n11);
        List<TreeNode> newTreeNodeList = new LinkedList<>();
        System.out.println(getLIS(n1 , newTreeNodeList));
    }

    @Test
    public void test_3(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);

        n1.setChild(n2,null);
        n2.setChild(n3,null);
        n3.setChild(n4,null);
        n4.setChild(n5,null);
//        n5.setChild(n6,null);

        List<TreeNode> newTreeNodeList = new LinkedList<>();
        System.out.println(getLIS(n1 , newTreeNodeList));
    }
}
