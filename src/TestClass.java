import data.TreeNode;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {



    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return result;
    }

    int result = 0 ;
    public int maxPathSumHelper(TreeNode root){
        if (root == null)
            return 0;

        int left = Math.max(maxPathSumHelper(root.left), 0 );
        int right = Math.max(maxPathSumHelper(root.right),0);

        result = Math.max(root.val + right + left , result);
        return root.val + Math.max(left , right);
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        root.setChild(n1,n2);
        n1.setChild(n3,n4);
        n2.setChild(n5,n6);
        System.out.println(maxPathSum(root));
    }

}
