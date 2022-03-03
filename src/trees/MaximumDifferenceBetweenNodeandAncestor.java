package trees;


import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class MaximumDifferenceBetweenNodeandAncestor {

    public int maxAncestorDiff(TreeNode root) {
        return dfsMax(root , 0 );
    }

    public int dfsMax(TreeNode root, int max){
        if (root == null)
            return 0;

        max = Math.max( max ,
                Math.max(
                        Math.abs(getMin(root) - root.val) ,
                        Math.abs(getMax(root) - root.val)
                )
        );


        return Math.max( max , Math.max(dfsMax(root.left , max) , dfsMax(root.right , max)));
    }
    public int getMin(TreeNode root){
        if (root == null)
            return Integer.MAX_VALUE;
        return Math.min(root.val , Math.min(getMin(root.left) , getMin(root.right)) );
    }

    public int getMax(TreeNode root){
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.val , Math.max(getMax(root.left) , getMax(root.right)) );
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
