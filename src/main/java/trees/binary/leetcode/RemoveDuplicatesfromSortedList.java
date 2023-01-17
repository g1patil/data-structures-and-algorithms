package trees.binary.leetcode;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import lists.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * Given the head of a sorted linked list, delete all duplicates
 * such that each element appears only once. Return the linked list sorted as well.
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode resultHead = head;
        ListNode current = head;
        ListNode runner = current;

        while (runner !=null ){
            while (runner!=null && runner.val == current.val){
                runner = runner.next;
            }
            current.next = runner;
            current = current.next;
        }
        return resultHead;
    }

    @Test
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(4);

        n1.setNext(n2).setNext(n3).setNext(n4).setNext(n5).setNext(n6).setNext(n7);
        deleteDuplicates(n1).printList();
    }
}
