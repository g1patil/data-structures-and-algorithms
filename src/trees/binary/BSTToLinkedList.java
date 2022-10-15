package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author jivanpatil
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 *
 * Note : helpful trick available.
 * If you want to create the pointer for the inorder traversla of the BT then,
 * create new two pointers. and keep assigning then values.
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class BSTToLinkedList {

    TreeNode first = null;
    TreeNode last = null;

    public void treeToDoublyListHelper(TreeNode root) {

       if (root !=null){
           treeToDoublyListHelper(root.left);

           if (first!=null){
               last.right = root;
               root.left = last;
           } else {
               first = root;
           }
           last = root;
           treeToDoublyListHelper(root.right);
       }
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null)
            return root;

        treeToDoublyListHelper(root);
        first.left = last;
        last.right = first;
        return first;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        root.setChild(n9, n20);
        n20.setChild(n15,n7);

        System.out.println(treeToDoublyList(root));
    }
}
