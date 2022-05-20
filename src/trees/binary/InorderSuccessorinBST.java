package trees.binary;

import annotation.Platform;
import annotation.Site;
import data.TreeNode;
import org.junit.jupiter.api.Test;
import trees.Tree;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 285. Inorder Successor in BST
 * */
@Platform(Site.LEETCODE)
public class InorderSuccessorinBST {


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Queue<TreeNode> queue = new PriorityQueue<>((x, y) -> Integer.compare(y.val, x.val));
        inorderSuccessorHelper(root, p ,  queue);
        return queue.peek();
    }

    private void inorderSuccessorHelper(TreeNode root, TreeNode p, Queue<TreeNode> queue) {
        if (root == null)
            return;
        inorderSuccessorHelper(root.left,p ,queue);
        if (root.val > p.val){
            queue.add(root);
            if (queue.size()>1)
                queue.poll();
        }
        inorderSuccessorHelper(root.right,p , queue);
    }

    public TreeNode inorderSuccessorOptimal(TreeNode root, TreeNode p) {
        TreeNode result = new TreeNode(-1);

        while (root!=null){
            if (p.val >= p.val){
                result = root;

            }
        }
    }


    @Test
    public void test(){
        TreeNode root = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        root.setChild(n1,n2);
        System.out.println(inorderSuccessor(root,n1));
    }
}
