package trees;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * 1373. Maximum Sum BST in Binary Tree
 * Reference : https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/discuss/534877/Java-One-pass-post-order-DFS-O(N)
 *
 */
@Quality(Stage.INCOMPLETE)
@Platform(Site.LEETCODE)
public class MaxSumBSTBinaryTree {

    int max = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode _node){

        if (_node == null)
            return true;

        if (_node.left == null && _node.right == null){
            max = Math.max( max , _node.val);
            return true;
        }


        boolean left = isValidBST(_node.left);
        boolean right = isValidBST(_node.right);

        int leftVal = _node.left == null ? 0 : _node.left.val;
        int rightVal = _node.right == null ? 0 : _node.right.val;

        if (left && right && _node.val < rightVal && _node.val > leftVal){
            max = Math.max( max , _node.val + leftVal + rightVal);
            return true;
        }

        return false;
    }

    public int maxSumBST(TreeNode root) {
        isValidBST(root);
        return max;
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(-10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(15);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(17);

        root.setChild(n1,n2);
        n2.setChild(n3,n4);
        System.out.println(maxSumBST(root));
    }


    @Test
    public void test_2(){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(4);
        TreeNode n8 = new TreeNode(6);


        root.setChild(n1,n2);
        n1.setChild(n3,n4);
        n2.setChild(n5,n6);
        n6.setChild(n7,n8);
        System.out.println(maxSumBST(root));
    }
}
