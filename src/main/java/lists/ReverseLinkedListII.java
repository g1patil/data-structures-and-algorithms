package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 92. Reverse Linked List II
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next  = head;
        ListNode previous = dummy;
        ListNode tail = dummy;
        int count = 0 ;

        while (count!=left -1 ){
            previous = previous.next;
            count++;
        }
        count = 0;
        while (count!=right+1){
            tail=tail.next;
            count++;
        }

        ListNode[] result = reverseList(previous.next , tail);
        previous.next = result[0];
        result[1].next = tail;

        return dummy.next;
    }

    public ListNode[] reverseList(ListNode head , ListNode tail){
        ListNode newTail = head;
        ListNode root = head;
        ListNode newHead = null;

        while (root!=null && root!= tail){
            ListNode temp = root.next;
            ListNode current = root;
            current.next = newHead;
            newHead = current;
            root = temp;
        }

        return new ListNode[]{newHead,newTail};
    }

    @Test
    public void test_(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.setNext(l2).setNext(l3).setNext(l4).setNext(l5);
        reverseBetween(l1, 2, 4 );
    }

    @Test
    public void test_2(){
        ListNode l1 = new ListNode(1);
        reverseBetween(l1, 1, 1 );
    }

    @Test
    public void test_3(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.setNext(l2);

        reverseBetween(l1, 1, 2 );
    }
}
