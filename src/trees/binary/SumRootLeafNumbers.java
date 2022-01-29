package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 129. Sum Root to Leaf Numbers
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SumRootLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root , 0 );
    }

    public int sumNumbersHelper(TreeNode root , int sum) {
        if (root == null)
            return 0;
        if (root !=null && root.left == null && root.right == null)
            return sum * 10 + root.val;

       return sumNumbersHelper(root.left , sum * 10 + root.val) +
        sumNumbersHelper(root.right , sum * 10 + root.val);
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(0);
//        TreeNode n2 = new TreeNode(3);

        root.setChild(n1,null);

        System.out.println(sumNumbers(root));
    }
}
