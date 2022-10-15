package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author g1patil
 * 199. Binary Tree Right Side View
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode current = queue.peek();

            for (int i = 0; i < size; i++) {
                current  = queue.poll();
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
            }
            result.add(current.val);
        }
        return result;
    }
    @Test
    public void test_(){
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.setChild(n2,n0);
        n2.setChild(n3,n4);
        System.out.println(rightSideView(n1));
    }
}
