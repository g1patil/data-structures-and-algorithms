import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {


    public int maxDepth(TreeNode root) {
        return depthDFS(root);
    }

    public int depthDFS(TreeNode root){
        if(root == null)
            return 0;

        int left = depthDFS(root.left);
        int right = depthDFS(root.right);

        return 1 + Math.max(left , right);
    }

}
