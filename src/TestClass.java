import model.TreeNode;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {



    //938. Range Sum of BST
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumBSTDFS(root,low,high);
    }

    private int rangeSumBSTDFS(TreeNode root, int low, int high){
        if(root == null)
            return 0;


        return (root.val >= low && root.val <= high ? root.val : 0) +
                rangeSumBSTDFS(root.left , low , high) +
                rangeSumBSTDFS(root.right , low , high);
    }


    @Test
    public void test(){

    }
}