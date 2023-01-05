import model.TreeNode;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {



    //1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return getTargetCopyHelper(original,cloned,target);
    }

    public final TreeNode getTargetCopyHelper(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null)
            return null;

        TreeNode left =  getTargetCopyHelper(original.left , cloned.left , target);
        if(original == target)
            return cloned;
        TreeNode right =  getTargetCopyHelper(original.right , cloned.right , target);

        return left == null ? right : left;
    }


    @Test
    public void test(){

    }
}