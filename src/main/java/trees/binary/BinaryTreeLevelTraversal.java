package trees.binary;

import model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 * */
public class BinaryTreeLevelTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return result;
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size ; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                if(node.left !=null)
                    queue.add(node.left);

                if(node.right !=null)
                    queue.add(node.right);
            }

            result.add(0,levelList);
        }

        return result;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(-10);
        TreeNode n1 = new TreeNode(-5);
        TreeNode n2 = new TreeNode(-6);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);

        root.setChild(n1,n2);
//        n1.setChild(n3,n4);
        n2.setChild(n5,n6);
        System.out.println(levelOrderBottom(root));
    }
}
