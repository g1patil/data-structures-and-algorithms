import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {


    public int getMaxSum(TreeNode root){
        if (root == null)
            return 0;

        return root.val + Math.max( getMaxSum(root.left) , getMaxSum(root.right));
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(2);
        n1.setChild(n3,n4);
        root.setChild(n1,n2);

        System.out.println(getMaxSum(root));
    }


}
