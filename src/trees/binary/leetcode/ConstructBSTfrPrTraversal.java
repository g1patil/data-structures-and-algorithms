package trees.binary.leetcode;

import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @auther g1patil
 */
public class ConstructBSTfrPrTraversal {

    private TreeNode root;

    private TreeNode addToTree( TreeNode root , int data){
        if (root == null)
            return new TreeNode(data);

        if ( data < root.getVal()){
            root.left = addToTree(root.left , data);
        } else root.right = addToTree(root.right , data);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {

         for (int i : preorder)
             root = addToTree(root , i);

         return root;
    }

    @Test
    public void test_(){
        TreeNode.printTreeStatic( bstFromPreorder(new int[]{8,5,1,7,10,12}));
    }
}
