package trees.binary;
import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;

import java.util.*;
/**
 * @author g1patil
 * 515. Find Largest Value in Each Tree Row
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FindLargestValueEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            int min = Integer.MIN_VALUE;
            for (int i = 0 ; i < size ; i ++){
                TreeNode node = q.poll();
                min = Math.max(min , node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            result.add(min);

        }
        return result;
    }
}
