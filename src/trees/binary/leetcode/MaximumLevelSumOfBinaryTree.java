package trees.binary.leetcode;

import model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * */
public class MaximumLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int result = Integer.MIN_VALUE ;
        queue.add(root);
        int level = 0;
        int maxLevelNumber = 1;

        while (!queue.isEmpty()){
            int size = queue.size();
            int currentSum = 0;
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                currentSum+=current.val;

                if (current.left!=null)
                    queue.add(current.left);
                if (current.right!=null)
                    queue.add(current.right);
            }

            if (currentSum > result)
                maxLevelNumber = level;
            result = Math.max(result,currentSum);
        }
        return maxLevelNumber;
    }

    @Test
    public void test(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n2.setChild(n1,n3);
        n4.setChild(n2,n6);
        n6.setChild(n5,n7);

        Assertions.assertEquals(3,maxLevelSum(n4));
    }

    @Test
    public void tes2(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(-8);

        n1.setChild(n2,n3);
        n2.setChild(n4,n5);

        Assertions.assertEquals(2,maxLevelSum(n1));
    }

    @Test
    public void tes3(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(-8);
        TreeNode n6 = new TreeNode(-7);
        TreeNode n7 = new TreeNode(9);

        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n3.setChild(n6,n7);

        Assertions.assertEquals(1,maxLevelSum(n1));
    }
}
