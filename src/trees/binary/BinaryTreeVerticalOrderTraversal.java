package trees.binary;


import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

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


    int leftMost = 0;
    int rightMost = 0 ;

    public void calculateNumberOfLists(TreeNode treeNode  , int _number){

        if (treeNode == null)
            return;

        calculateNumberOfLists(treeNode.left , _number - 1);
        leftMost = Math.min(_number , leftMost);
        rightMost = Math.max(_number , rightMost);
        calculateNumberOfLists(treeNode.right , _number +  1);

    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        nodeQueue.add(root);
        indexQueue.add(0);

        bfsTraversal(root , nodeQueue , indexQueue , map);

        for (int i = leftMost; i <= rightMost; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    private void bfsTraversal(TreeNode root, Queue<TreeNode> nodeQueue , Queue<Integer> indexQueue, Map<Integer, List<Integer>> map) {

        while (!nodeQueue.isEmpty()){
            TreeNode node  = nodeQueue.poll();
            int index =  indexQueue.poll();

            if (!map.containsKey(index)){
                map.put(index , new ArrayList<>());
            }

            map.get(index).add(node.val);

            if (node.left!=null){
                nodeQueue.add(node.left);
                indexQueue.add(index - 1);
            }

            if (node.right!=null){
                nodeQueue.add(node.right);
                indexQueue.add(index + 1);
            }
        }
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
        n0.setChild(null, n2);
        root.setChild(n9,n8);
        n8.setChild(n1,n7);
        n1.setChild(n5,null);

        System.out.println(verticalOrder(root));
    }

    @Test
    public void test3(){
        TreeNode root = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n4 = new TreeNode(4);
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n9.setChild(n4,n0);
        root.setChild(n9,n8);
        n8.setChild(n1,n7);

        System.out.println(verticalOrder(root));
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
//        System.out.println(verticalTraversal(root));
    }
}
