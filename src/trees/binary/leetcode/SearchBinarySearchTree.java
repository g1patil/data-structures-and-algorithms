package trees.binary.leetcode;

import graph.TreeNode;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if ( root == null)
            return root;

        if (root.data == val)
            return root;

        return val < root.data ? searchBST(root.leftNode, val) : searchBST(root.rightNode, val);

    }

    @Test
    @DisplayName("test")
    public void test(){


    }
}
