package trees.binary;

import annotation.Platform;
import annotation.Site;
import data.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 285. Inorder Successor in BST
 * */
@Platform(Site.LEETCODE)
public class InorderSuccessorinBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode treeNode = new TreeNode(-1)
        inorderSuccessorHelper(root,p,false , treeNode );
        return treeNode;
    }

    public void inorderSuccessorHelper(TreeNode root, TreeNode p, boolean found , TreeNode result) {
        if (root.left == null && root.right == null)
            return ;
        if (found && root != null){
            root = result;
            return;
        }
        inorderSuccessorHelper(root.left , p , found , result);
        if (root.val == p.val)
            found = true;
        inorderSuccessorHelper(root.right , p , found , result);

        return ;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.setChild(n1,n2);
        System.out.println(inorderSuccessor(root,n1));
    }
}
