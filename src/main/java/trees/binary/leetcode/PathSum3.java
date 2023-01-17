package trees.binary.leetcode;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 *
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/
 *
 * Given the root of a binary tree and an integer targetSum,
 * return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 * Old impl/working : binary/PathSum3.java
 * */
@Platform(Site.LEETCODE)
@Quality(value = Stage.FAILING,details = "127/128")
public class PathSum3 {

    public int pathSum(TreeNode root, int targetSum) {
        return pathSumDFS(root , targetSum);
    }

    private int pathSumDFS(TreeNode root, int target){
        if (root == null)
            return 0;

        return pathSumDFS(root.left , target) +
        pathSumForNode(root , target , 0 ) +
        pathSumDFS(root.right , target);
    }

    public int pathSumForNode(TreeNode root , int target , int currentSum){
        if (root == null)
            return 0;

        return (root.val + currentSum == target ? 1 : 0)  +
                pathSumForNode(root.left , target , currentSum + root.val) +
                        pathSumForNode(root.right , target , currentSum + root.val);

    }

    @Test
    public void test(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(-2);
        TreeNode n3 = new TreeNode(-3);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(-2);
        TreeNode n7 = new TreeNode(-1);

        n1.setChild(n2,n3);
        n2.setChild(n4,n5);
        n3.setChild(n6,null);
        n4.setChild(n7, null);

        System.out.println(pathSum(n1,-1));
    }
}
