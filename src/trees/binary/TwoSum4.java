package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;

import java.util.HashSet;

/**
 * @author g1patil
 * 653. Two Sum IV - Input is a BST
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class TwoSum4 {

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet();
        return dfs(root ,  k , set);
    }

    public boolean dfs(TreeNode root, int k , HashSet<Integer> set){
        if(root == null)
            return false;

        if(set.contains( k - root.val))
            return true;
        set.add(root.val);

        if(dfs(root.left , k , set) || dfs(root.right , k , set)){
            return true;
        }

        return false;
    }
}
