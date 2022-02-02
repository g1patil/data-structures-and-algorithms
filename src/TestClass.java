import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {


    public boolean result = true ;
    public boolean isBalanced(TreeNode root) {
        treeBalance(root);
        return result;
    }

    public int treeBalance(TreeNode root){

        if(root == null)
            return 0;

        int left = treeBalance(root.left);
        int right = treeBalance(root.right);

        if(Math.abs(left - right) > 1)
            result = false;
        return 1 + Math.max(left, right);
    }

    @Test
    public void test_(){
        System.out.println(canConstruct("hello" , "hlo world"));
    }

}
