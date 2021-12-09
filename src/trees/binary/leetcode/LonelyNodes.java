package trees.binary.leetcode;

import data.TreeNode;
import lists.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther g1patil
 */
public class LonelyNodes {

    List<Integer> integerList = new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        if (root == null)
            return integerList;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if ( ( left == null && right!=null) || ( right == null && left!=null) ){
            if (right != null){
                integerList.add(right.getData());
                getLonelyNodes(right);
            }
            if (left!=null){
                integerList.add(left.getData());
                getLonelyNodes(left);
            }
        } else {
            getLonelyNodes(right);
            getLonelyNodes(left);
        }

        return integerList;
    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.setChild(n2,n3);
        n2.setChild(null, n4);
        System.out.println(getLonelyNodes(n1));

    }
}
