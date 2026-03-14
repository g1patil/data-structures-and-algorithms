package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        dfs(root , result , "");
        return result;
    }

    public void dfs(TreeNode root,List<String> result , String current){

        if(root.left!=null)
            dfs(root.left , result , current + root.val + "->");

        if(root.right!=null)
            dfs(root.right , result , current + root.val + "->");

        if(root.left == null && root.right == null)
            result.add(current + root.val);

    }

}
