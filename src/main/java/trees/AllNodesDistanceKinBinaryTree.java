package trees;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author g1patil
 * 863. All Nodes Distance K in Binary Tree
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class AllNodesDistanceKinBinaryTree {

    public Map<Integer,TreeNode> buildParentMap(TreeNode root  , TreeNode parent, Map<Integer,TreeNode> map){
        if (root == null)
            return map;
        map.put(root.val , parent);
        buildParentMap(root.left , root , map);
        buildParentMap(root.right , root , map);
        return map;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer,TreeNode> map = buildParentMap(root , null , new HashMap<>());
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int count = 0 ;

        while (count < k && !q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                seen.add(current.val);

                if (current.left !=null && !seen.contains(current.left.val))
                    q.add(current.left);
                if (current.right !=null && !seen.contains(current.right.val))
                    q.add(current.right);
                if (map.get(current.val)!=null && !seen.contains(map.get(current.val).val))
                    q.add(map.get(current.val));

            }
            count++;
        }
        return q.stream().map(o->o.val).collect(Collectors.toList());
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
        System.out.println(distanceK(root ,n1 , 3));
    }
}
