package trees.binary;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import data.TreeNode;
import lists.ListNode;

import java.util.ArrayList;

/**
 * @author g1patil
 * 109. Convert Sorted List to Binary Search Tree
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ConvertSortedListtoBinarySearchTree {

    ArrayList<Integer> list = new ArrayList();

    public void buildList(ListNode head){
        ListNode root = head;
        while(root!=null){
            list.add(root.val);
            root = root.next;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        buildList(head);
        return sortedListToBSTHelper(0 , list.size() -1 );
    }

    public TreeNode sortedListToBSTHelper(int i , int j){
        if(j<i)
            return null;

        int mid = (i+j)/2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = sortedListToBSTHelper(i , mid - 1);
        node.right = sortedListToBSTHelper(mid+1,j);

        return node;
    }
}
