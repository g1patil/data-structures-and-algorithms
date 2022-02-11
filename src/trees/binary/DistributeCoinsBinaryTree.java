package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 979. Distribute Coins in Binary Tree
 *
 * Algo :
 * For each node, run dfs.
 * Return the excess coin that you have. If you receive anything from left
 * and right node, then add them with what you have , keep one and return the
 * remaining one.
 * At each return value, take the absolute of that and add to result/
 * the values flowing through the network is the final result
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class DistributeCoinsBinaryTree {

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    int result = 0;
    public int dfs(TreeNode root){
        if (root == null)
            return  0 ;

        int left = dfs(root.left);
        int right = dfs(root.right);

        result+= Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1 ;
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(3);
        root.setChild(n1,n2);
        System.out.println(distributeCoins(root));
    }
}
