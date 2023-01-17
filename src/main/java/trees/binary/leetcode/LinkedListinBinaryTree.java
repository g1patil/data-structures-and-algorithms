package trees.binary.leetcode;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import lists.ListNode;
import model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 1367. Linked List in Binary Tree
 * Really slow :-(
 * */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class LinkedListinBinaryTree {

    public boolean isSubPath(ListNode head, TreeNode root) {
        Map<String,Integer> map = new HashMap<>();
        buildMap(map,root,"");
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;

        while (temp!=null){
            sb.append(temp.val);
            temp = temp.next;
        }
        for (String s : map.keySet()){
            if (s.contains(sb.toString()))
                return true;
        }
        return false;
    }

    private void buildMap(Map<String, Integer> map, TreeNode root, String s) {
        if (root == null){
            map.put(s,0);
            return;
        }
        buildMap(map,root.left , s + String.valueOf(root.val));
        buildMap(map,root.right , s + String.valueOf(root.val));
    }

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.setChild( t2, t3);
        t2.setChild(t4,t5);
        t3.setChild(t6,t7);

        ListNode n1 = new ListNode(1);
        n1.setNext(new ListNode(2)).setNext(new ListNode(4));

        System.out.println(isSubPath(n1 , t1));
    }
}
