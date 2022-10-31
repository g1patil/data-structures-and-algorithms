package trees.binary.leetcode;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 *
 * Given the root of a binary tree,
 * return the sum of values of nodes with an even-valued grandparent.
 * If there are no nodes with an even-valued grandparent, return 0.
 *
 * A grandparent of a node is the parent of its parent if it exists.
 * */
@Platform(Site.LEETCODE)
@Quality(Stage.INCOMPLETE)
public class SumofNodeswithEvenValuedGrandparent {

    public int sumEvenGrandparent(TreeNode root) {
        return getGCSum(root);
    }

    private int getGCSum(TreeNode root) {
        if (root == null)
            return 0;

        return root.val % 2 == 0 ? getGCSum(root ,  0 ) : getGCSum(root.left) + getGCSum(root.right);
    }

    private int getGCSum(TreeNode root, int level){
        if (root == null)
            return 0;

        if (level == 2){
            return root.val;
        }

        return getGCSum(root.left , level + 1) +
                getGCSum(root.right , level + 1);
    }

    @Test
    public void test(){

        /**
         *       2
         *      2   3
         *     4 5 6 7
         *     89
         * */

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n3.setChild(n6,n7);
        n4.setChild(n8, n9 );
        System.out.println(sumEvenGrandparent(n1));
    }
}
