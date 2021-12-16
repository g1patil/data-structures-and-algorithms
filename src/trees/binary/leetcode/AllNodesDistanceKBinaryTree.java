package trees.binary.leetcode;

import annotation.Platform;
import annotation.Site;
import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

/**
 * @author g1patil
 */
@Platform(Site.LEETCODE)
public class AllNodesDistanceKBinaryTree {

    int counter;
    boolean found = false;
    Stack<Integer> integerStack = new Stack<>();

    private void distanceHelper(TreeNode treeNode , int target , int distance){
        if (treeNode == null)
            return;
        if (found == true){
            counter+=1;
        }
        integerStack.push(treeNode.getData());
        if (distance == Math.abs(counter) ){
            System.out.println("element found : " + treeNode.getData());
        }
        if (treeNode.getData() == target){
            found = true;
        }
        distanceHelper(treeNode.left , target , distance);
        distanceHelper(treeNode.right , target , distance);
        integerStack.pop();

        if (found){
            counter-=1;
        }
    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.setChild(n2,n3);
        n2.setChild(n4,n5);

        distanceHelper(n1,2 , 1 );
    }
}
