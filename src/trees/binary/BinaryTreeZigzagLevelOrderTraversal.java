package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import data.TreeNode;
import lists.LinkedListCycle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author g1patil
 * 103. Binary Tree Zigzag Level Order
 */
@Platform(Site.LEETCODE)
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> even = new LinkedList<>();
        LinkedList<TreeNode> odd = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>();

        odd.add(root);
        current = odd;

        int level = 1 ;
        while (!current.isEmpty()){
            int size  = current.size();
            result.add(new ArrayList<>());

            for (int i = 0; i < size; i++) {
                TreeNode node = current.poll();
                result.get(level).add(node.val);

                if (level % 2 == 1){
                    even.add(node.right);
                    even.add(node.left);
                } else {
                    odd.addFirst(node.left);
                    odd.addFirst(node.right);
                }
            }
            level++;
        }

        return result;
    }

    @Test
    public void test_(){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        root.setChild(n1,n2);
        n1.setChild(n3,n4);
        n2.setChild(n5,n6);

        zigzagLevelOrder(root);
    }
}
