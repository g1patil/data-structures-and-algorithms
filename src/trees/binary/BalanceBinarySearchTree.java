package trees.binary;

import data.TreeNode;
import org.junit.jupiter.api.Test;
import trees.Tree;

/**
 * @author g1patil
 *
 * 1382. Balance a Binary Search Tree
 */
public class BalanceBinarySearchTree {

    TreeNode root ;

    public TreeNode addNode(int data , TreeNode root){
        if (root == null){
            return new TreeNode(data);
        }

        if (data < root.val)
           root.left =  addNode(data , root.left);
        else  root.right = addNode(data , root.right);

        return root;
    }

    public void printMiddle(int i , int j , int[] ints){
        if (i <0 || j < 0)
            return;
        if (j < i || j >= ints.length )
            return;

        int middle = (i + j)/2 ;
        root = addNode(ints[middle] , root);

        printMiddle(i, middle-1 , ints);
        printMiddle( middle + 1, j , ints);
    }


    @Test
    public void test_(){
        int[] ints = new int[]{1,2,3,4};
        printMiddle(0 , 3 ,ints);
        System.out.println();
    }
}
