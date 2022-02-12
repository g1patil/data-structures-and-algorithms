package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import lists.ListNode;
import org.junit.jupiter.api.Test;
import trees.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author g1patil
 * 102. Binary Tree Level Order Traversal
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);
        int level = 0 ;
        while (!queue.isEmpty()){
            int size  = queue.size();
            result.add(new ArrayList<>());

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                result.get(level).add(node.val);

                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
            level++;
        }

        return result;
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(20);
        root.setChild(n1,n2);

        levelOrder(root);
    }
}
