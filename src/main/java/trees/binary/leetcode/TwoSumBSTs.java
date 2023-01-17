package trees.binary.leetcode;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1214. Two Sum BSTs
 *
 *Given the roots of two binary search trees, root1 and root2,
 * return true if and only if there is a node in the first tree and a node in the
 * second tree whose values sum up to a given integer target.
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class TwoSumBSTs {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        buildTheMap(map, root1);
        return treeContains(map,root2,target);
    }

    private boolean treeContains(Map<Integer, Integer> map, TreeNode root2, int target) {
        if (root2 == null)
            return false;

        if (map.containsKey(target - root2.val))
            return true;

        return treeContains(map,root2.left,target) ||
                treeContains(map , root2.right , target);
    }

    private void buildTheMap(Map<Integer,Integer> map , TreeNode root){
        if (root == null)
            return;

        map.put(root.val,-1);
        buildTheMap(map,root.left);
        buildTheMap(map,root.right);

    }
}
