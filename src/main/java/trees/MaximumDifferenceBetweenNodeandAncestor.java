package trees;


import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 1026. Maximum Difference Between Node and Ancestor
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MaximumDifferenceBetweenNodeandAncestor {

    public int maxAncestorDiff(TreeNode root) {
        return dfsMax(root , root.val , root.val );
    }

    public int dfsMax(TreeNode root , int min ,int max){
        if (root == null)
            return min - max;

        min = Math.min(root.val , min);
        max  = Math.max( root.val , max);

        return Math.max(
                dfsMax(root.left , min , max),
                dfsMax(root.right , min , max)
        );
    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.setChild(n2,n3);
        System.out.println(maxAncestorDiff(n1));
    }
}
