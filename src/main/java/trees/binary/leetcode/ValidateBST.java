package trees.binary.leetcode;

import model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 *
 * 98. Validate Binary Search Tree
 * Passes all cases.
 * Idea is to do inorder traversal, and build the linked list of all the elements
 * Then traverese the list and validate if it has the sorted elements
 */
public class ValidateBST {

   List<Integer> integerList = new ArrayList();

   /**
    * Builds the list from the given tree node
    * @param treeNode root node from which list will be built
    * @return list of tree val
    * */
   private List<Integer> getNodesList(TreeNode treeNode){
       if (treeNode == null)
           return integerList;

       getNodesList(treeNode.left);
       integerList.add(treeNode.getVal());
       getNodesList(treeNode.right);

       return integerList;
   }

   /**
    * Validates if the tree is valid BST
    * */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        integerList = getNodesList(root);
        if (integerList.isEmpty()){
            return true;
        } else {
            int previous = integerList.get(0);
            for (int i = 1; i < integerList.size(); i++) {
                if (integerList.get(i) <= previous){
                    return false;
                } else {
                    previous = integerList.get(i);
                }
            }
        }

        return true;
    }

    @Test
    public void test_(){
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(15);
        TreeNode n8 = new TreeNode(1);
        TreeNode n9 = new TreeNode(8);

        n2.setChild(n4,n5);
        n3.setChild(n6,n7);
        n5.setChild(n8,n9);
        n1.setChild(n2 , n3 );

        Assertions.assertFalse(isValidBST(n1));
    }
}
