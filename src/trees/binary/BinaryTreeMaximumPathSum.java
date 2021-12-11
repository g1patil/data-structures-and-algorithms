package trees.binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any node sequence from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 * */
public class BinaryTreeMaximumPathSum {

    /**
     * Given the node, returns the longest path sum from that node
     * @param node given node
     * @param sum, current sum
     * @return sum of the largest value till the leaf
     * */
    int getMaxSum(final Node node, int sum){

        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return node.data + sum;
        }

        return  Math.max(getMaxSum(node.left, node.data),getMaxSum(node.right, node.data));
    }

    /**
     * Given the node, gets the sum of the diameter. Here diameter will be considered as the largest sum
     * @param root given node
     * @return returns the sum of the maximum path
     *
     * */
    private int maxPathSum(Node root) {

        if(root == null){
            return 0;
        }
        int leftSum = getMaxSum(root.left, 0) ;
        int rightSum = getMaxSum(root.right , 0) ;

        return Math.max( leftSum + rightSum + root.data , Math.max(
                maxPathSum(root.left), maxPathSum(root.right)
        ));

    }

    @Test
    public void test(){
        Node root = new Node(10);
        Assertions.assertEquals(10,maxPathSum(root));
    }

    @Test
    public void test2(){
        Node root = new Node(10);
        Node n1 = new Node(5);
        Node n2 = new Node(6);

        root.left = n1;
        root.right = n2;

        Assertions.assertEquals(21,maxPathSum(root));
    }

    @Test
    public void test3(){
        Node root = new Node(10);
        Node n1 = new Node(5);
        Node n2 = new Node(6);

        Node n3 = new Node(11);
        Node n4 = new Node(12);

        root.left = n1;
        root.right = n2;

        n2.left = n3;
        n2.right = n4;

        Assertions.assertEquals(33,maxPathSum(root));
    }

    @Test
    public void test4(){
        Node root = new Node(10);
        Node n1 = new Node(5);
        Node n2 = new Node(6);

        Node n3 = new Node(11);
        Node n4 = new Node(12);

        Node n5 = new Node(100);
        Node n6 = new Node(200);

        root.left = n1;
        root.right = n2;

        n2.left = n3;
        n2.right = n4;

        n1.left = n5;
        n1.right = n6;

        Assertions.assertEquals(305,maxPathSum(root));
    }
}
