package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;

import java.util.*;

/**
 * 2385. Amount of Time for Binary Tree to Be Infected
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class BinaryTreeBeInfected {

    public int amountOfTime(TreeNode root, int start) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer,TreeNode> parent = new HashMap<>();
        builtParentMap(root,parent);

        TreeNode startNode = getStartNode(root,start);
        Queue<TreeNode> q = new LinkedList<>();
        int result = 0;
        q.add(startNode);
        visited.add(start);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++) {

                TreeNode current = q.poll();

                if(current.left!=null && !visited.contains(current.left.val)){
                    visited.add(current.left.val);
                    q.add(current.left);
                }
                if(current.right!=null && !visited.contains(current.right.val)){
                    visited.add(current.right.val);
                    q.add(current.right);
                }
                if(parent.get(current.val)!=null && !visited.contains(parent.get(current.val).val)){
                    visited.add(parent.get(current.val).val);
                    q.add(parent.get(current.val));
                }
            }
            result++;
        }
        return result-1;
    }

    private TreeNode getStartNode(TreeNode root, int start){
        if(root == null)
            return null;

        if(root.val == start)
            return root;

        TreeNode left = getStartNode(root.left,start);
        TreeNode right = getStartNode(root.right,start);

        return left != null ? left : right;
    }

    private void builtParentMap(TreeNode root,Map<Integer,TreeNode> parent){
        if(root == null)
            return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left!=null)
            parent.put(left.val,root);

        if(right!=null)
            parent.put(right.val,root);

        builtParentMap(root.left,parent);
        builtParentMap(root.right,parent);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(10);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(2);
        root.setChild(n1,n2);
        n1.setChild(null,n3);
        n2.setChild(n4,n5);
        n3.setChild(n6,n7);

        System.out.println(
                new BinaryTreeBeInfected().amountOfTime(root,3)
        );
    }
}
