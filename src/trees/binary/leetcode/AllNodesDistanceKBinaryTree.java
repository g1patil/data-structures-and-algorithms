package trees.binary.leetcode;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

/**
 * @author g1patil
 */
@Platform(Site.LEETCODE)
@Quality(value = Stage.BUGGY, details = "only works for one half. The other half does not work")
public class AllNodesDistanceKBinaryTree {

    int counter;
    int reverse;
    boolean found = false;
    Stack<Integer> integerStack = new Stack<>();

    private void distanceHelper(TreeNode treeNode , int target , int distance){
        if (treeNode == null)
            return;
        if (distance == Math.abs(counter) || distance == Math.abs(reverse) ){
            System.out.println("element found : " + integerStack.peek());
        }
        integerStack.push(treeNode.getData());
        if (found == true){
            counter = Math.abs(counter) + 1 ;
            reverse = Math.abs(reverse) - 1 ;
        }
        if (distance == Math.abs(counter) || distance == Math.abs(reverse) ){
            System.out.println("element found : " + integerStack.peek());
        }
        if (treeNode.getData() == target){
            found = true;
        }
        distanceHelper(treeNode.left , target , distance);
        distanceHelper(treeNode.right , target , distance);
        integerStack.pop();

        if (found){
            counter-=1;
            reverse+=1;
        }
    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n3.setChild(n6,n7);

        distanceHelper(n1,4 , 2 );
    }
}
