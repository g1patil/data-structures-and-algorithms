import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    //110. Balanced Binary Tree
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return result;

        isBalancedHelper(root);
        return result;
    }

    private int isBalancedHelper(TreeNode root){
        if(root == null)
            return 0;

        int left = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);

        if(Math.abs(left - right) > 1)
            result = false;

        return 1 + Math.max( left , right );
    }


    @Test
    public void test(){
        System.out.println(
        );
    }

}
