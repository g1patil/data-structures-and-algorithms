import data.TreeNode;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {


    int totalNodes = 0 ;
    public int maxPathSum(TreeNode root) {
        int[] result = maxPathSumHelper(root);
        return totalNodes - Math.max(result[0] , result[1]);
    }

    public int[] maxPathSumHelper(TreeNode root){
        if (root == null)
            return new int[2];

        int[] left = maxPathSumHelper(root.left);
        int[] right = maxPathSumHelper(root.right);

        int[] result = new int[2];

        result[1] = root.val + left[0] + right[0];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]) ;
        totalNodes++;

        return result;
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        root.setChild(n1,n2);
        n1.setChild(n3,n4);
        n2.setChild(n5,n6);
        System.out.println(maxPathSum(root));
    }

    @Test
    public void test_2(){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);

        root.setChild(n1 , null);
        n1.setChild(n2, null);
        n2.setChild(n3,null);
        n3.setChild(n4 , null);
        n4.setChild(n5 , null);

        System.out.println(minCameraCover(root));
    }

    int res = 0;
    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }

}
