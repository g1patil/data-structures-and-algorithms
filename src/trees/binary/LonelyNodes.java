package trees.binary;

import data.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * In a binary tree, a lonely node is a node that is the only child of its parent node.
 * The root of the tree is not lonely because it does not have a parent node.
 *
 * Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree.
 * Return the list in any order.
 *
 * */
public class LonelyNodes {

    /**
     * @param root root node
     * @return List of nodes who are only child to their parent
     * */
    List<Integer> lonelyNodes(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root.left != null && root.right != null){
            result.addAll(lonelyNodes(root.left));
            result.addAll(lonelyNodes(root.right));
        } else if ( root.left == null && root.right !=null ){
            result.add(root.right.getVal());
            result.addAll(lonelyNodes(root.right));

        } else if ( root.right == null && root.left !=null ) {
            result.add(root.left.getVal());
            result.addAll(lonelyNodes(root.left));
        }
        return result;
    }

    @Test
    public void test(){
        TreeNode node = new TreeNode(10);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        TreeNode r2 = new TreeNode(4);
        TreeNode l3 = new TreeNode(5);
        TreeNode r3 = new TreeNode(6);

        node.left = l1 ;
        l1.left = l2 ;
        l2.left = l3 ;

        node.right = r1 ;
        r1.right = r2 ;
        r2.right = r3 ;

        Assertions.assertEquals(lonelyNodes(node).size(),4);
    }

    @Test
    public void test2(){
        TreeNode node = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(4);
        TreeNode r1 = new TreeNode(3);

        node.left = l1 ;
        node.right = r1 ;
        l1.right = r2 ;

        Assertions.assertEquals(lonelyNodes(node).size(),1);
    }

    @Test
    public void test3(){
        TreeNode node = new TreeNode(1);
        Assertions.assertEquals(lonelyNodes(node).size(),0);
    }
}
