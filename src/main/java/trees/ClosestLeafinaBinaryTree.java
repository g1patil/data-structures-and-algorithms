package trees;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 * 742. Closest Leaf in a Binary Tree
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ClosestLeafinaBinaryTree {

    Map<Integer,TreeNode> buildParentMap(TreeNode root , TreeNode parent , Map<Integer,TreeNode> map){
        if (root == null)
            return map;

        map.put(root.val , parent);
        buildParentMap(root.left , root , map);
        buildParentMap(root.right , root , map);

        return map;
    }
    public int findClosestLeaf(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        Map<Integer,TreeNode> parents = buildParentMap(root , null , new HashMap<>());
        TreeNode target = getTargetNode(root , k);

        q.add(target);
        while (!q.isEmpty()){
            TreeNode current = q.poll();

            if (current.left == null && current.right == null)
                return current.val;
            seen.add(current.val);

            if (current.left!=null && !seen.contains(current.left.val))
                q.add(current.left);
            if (current.right!=null && !seen.contains(current.right.val))
                q.add(current.right);

            TreeNode parent = parents.get(current.val);
            if (parent!=null && !seen.contains(parent.val))
                q.add(parent);
        }
        return -1;
    }
    public TreeNode getTargetNode(TreeNode root , int target){
        if (root == null)
            return root;
        if (root.val == target)
            return root;

        TreeNode left = getTargetNode(root.left , target);
        if (left!=null)
            return left;
        return getTargetNode(root.right , target);
    }


    @Test
    public void test_(){
        TreeNode root = new TreeNode(-10);
        TreeNode n1 = new TreeNode(-5);
        TreeNode n2 = new TreeNode(-6);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        root.setChild(n1,n2);
        n1.setChild(n3,n4);
        n2.setChild(n5,n6);
        System.out.println(findClosestLeaf(root , -6));
    }

}
