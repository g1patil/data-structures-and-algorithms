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
        return inorderSuccessorHelper(root,p,false);
    }

    public TreeNode inorderSuccessorHelper(TreeNode root, TreeNode p, boolean found) {
        if (found || root == null)
            return root;
        inorderSuccessorHelper(root.left , p , found);
        if (root.val == p.val)
            found = true;
        inorderSuccessorHelper(root.right , p , found);

        return null;
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
