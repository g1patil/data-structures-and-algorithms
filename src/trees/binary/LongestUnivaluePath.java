package trees.binary;

import data.TreeNode;
import org.junit.jupiter.api.Test;
import trees.Tree;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author g1patil
 */
public class LongestUnivaluePath {
    Queue<Integer> queue = new PriorityQueue<>();

    private Queue getAllNodes(TreeNode treeNode){
        if (treeNode == null)
            return queue;

        queue.add(treeNode.getData());
        getAllNodes(treeNode.left);
        getAllNodes(treeNode.right);
        return queue;
    }

    private int getLongestPathNode(TreeNode treeNode , int target ){
        int leftLength = 0;
        int rightLength = 0;

        if (treeNode == null)
            return 0;

        if (treeNode.left != null && treeNode.getData() == target && treeNode.left.getData() == treeNode.getData())
             leftLength = 1 + getLongestPathNode(treeNode.left , target );

        if (treeNode.right != null && treeNode.getData() == target && treeNode.right.getData() == treeNode.getData())
             rightLength = 1 + getLongestPathNode(treeNode.right , target );

        return Math.max( leftLength + rightLength ,
                Math.max(
                        getLongestPathNode(treeNode.left , target ),
                        getLongestPathNode(treeNode.right , target )
                )
                );
    }
    public int longestUnivaluePath(TreeNode root) {
        int longestUnivaluePath = Integer.MIN_VALUE;

        queue = getAllNodes(root);

        if (queue.isEmpty())
            return 0;

        while (!queue.isEmpty()){
            int node = queue.poll();
            longestUnivaluePath = Math.max( longestUnivaluePath , getLongestPathNode(root , node));
        }

        return longestUnivaluePath;
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

}
