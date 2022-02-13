package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * @author g1patil
 * 103. Binary Tree Zigzag Level Order Traversal
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayDeque<TreeNode> even = new ArrayDeque<>();
        ArrayDeque<TreeNode> odd = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<TreeNode> current ;

        odd.add(root);
        current = odd;

        int level = 1 ;
        while (!current.isEmpty()){
            int size  = current.size();
            result.add(new ArrayList<>());

            for (int i = 0; i < size; i++) {
                TreeNode node = (level % 2 == 1) ? current.removeLast() : current.removeLast();
                result.get(level - 1).add(node.val);

                if (level % 2 == 1){
                    if (node.left!=null)
                        even.add(node.left);
                    if (node.right!=null)
                        even.add(node.right);
                } else {
                    if (node.right!=null)
                        odd.add(node.right);
                    if (node.left!=null)
                        odd.add(node.left);
                }
            }
            if (level % 2 == 1)
                current = even;
            else current = odd;

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
