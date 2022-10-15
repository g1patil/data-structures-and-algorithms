package trees.binary.leetcode;


import model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 1302. Deepest Leaves Sum
 * */
public class DeepestLeavesSum {

    /**
     * DFS approach
     * */
    public int deepestLeavesSum(TreeNode root) {
        int deepestLevel = 0;
        Map<Integer,Integer> levelSum  = new HashMap();
        deepestLevel = deepestLeavesSumHelper(root,deepestLevel,levelSum);
        return levelSum.get(deepestLevel);
    }

    private int deepestLeavesSumHelper(TreeNode root,int level,Map<Integer,Integer> levelSum){
        if (root == null)
            return level - 1;

        levelSum.put(level,levelSum.getOrDefault(level,0) + root.val);
        return Math.max( deepestLeavesSumHelper(root.left , level + 1 , levelSum),
                deepestLeavesSumHelper(root.right , level + 1 , levelSum)
                );
    }

    public int deepestLeavesSum2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int sum = 0 ;
        queue.add(root);
        while (!queue.isEmpty()){
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                sum+=current.val;

                if (current.left!=null)
                    queue.add(current.left);
                if (current.right!=null)
                    queue.add(current.right);
            }
        }
        return sum;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(10);
        root.setChild(new TreeNode(5), new TreeNode(6));
        System.out.println(deepestLeavesSum(root));
    }

    @Test
    public void test2(){
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(9);
        TreeNode n5 = new TreeNode(10);
        TreeNode n6 = new TreeNode(11);

        root.setChild(n1,n2);
        n1.setChild(n3,null);
        n2.setChild(null,n6);

        System.out.println(deepestLeavesSum2(root));
    }
}
