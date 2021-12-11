package trees.binary;

import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Code for DFS traversal of the Binary Tree
 * Inorder traversal. LDR (Left,Data,Right)
 * 
 * 
*/
public class OrderTraversal {

    List<Integer> integerList = new ArrayList<>();

    public List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null)
            return integerList;
        inOrderTraversal(root.left);
        integerList.add(root.getData());
        inOrderTraversal(root.right);

        return integerList;
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null)
            return integerList;
        integerList.add(root.getData());
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

        return integerList;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null)
            return integerList;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        integerList.add(root.getData());

        return integerList;
    }

    @Test
    public void test_(){

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.setChild(null , n2 );
        n2.setChild(null , n3);
        System.out.println(inOrderTraversal(n1));
        integerList.removeAll(integerList);
        System.out.println(preOrderTraversal(n1));
        integerList.removeAll(integerList);
        System.out.println(postOrderTraversal(n1));
    }
}