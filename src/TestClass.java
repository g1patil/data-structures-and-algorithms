import model.TreeNode;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {


    /*
    * 98. Validate Binary Search Tree
    * */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        TreeNode previous = null;
        while(temp !=null || !stack.isEmpty()){
            while(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if(previous!=null && temp.val <= previous.val){
                return false;
            }
            previous = temp;
            temp = temp.right;
        }
        return true;
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

        System.out.println(isValidBST(n4));
    }
}