package trees.binary.leetcode;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 654. Maximum Binary Tree
 * You are given an integer array nums with no duplicates.
 * A maximum binary tree can be built recursively from nums using the following algorithm:
 *
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums.
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MaxBinaryTree {


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeHelper(0 , nums.length - 1  , nums);
    }

    public TreeNode constructMaximumBinaryTreeHelper(int start , int end , int[] nums) {
        TreeNode root = null;

        if (end < 0 || start >= nums.length || end < start)
            return root;

        int maxIndex = getMax(start,end,nums);
        root = new TreeNode(nums[maxIndex]);

        root.left = constructMaximumBinaryTreeHelper(start , maxIndex - 1  , nums);
        root.right = constructMaximumBinaryTreeHelper(maxIndex + 1  ,  end , nums);
        return root;
    }

    private int getMax(final int start , final int end , final int[] arr){
        int max = Integer.MIN_VALUE;
        int resultIndex = -1;
        for (int i = start; i <= end; i++) {
            if (arr[i] > max){
                max = arr[i];
                resultIndex = i ;
            }
        }
        return resultIndex;
    }

    @Test
    public void test(){
        TreeNode.printTreeStatic(constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
    }
}
