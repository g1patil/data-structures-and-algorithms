package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 19. Remove Nth Node From End of List
 *
 * Calculate size and remove size - Nth node
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class RemoveNthNodeFromEnd {

    public int getSize(ListNode node){
        int size = 0 ;
        ListNode temp = node;

        while (temp != null){
            size++;
            temp = temp.next;
        }

        return size;
    }

    /**
     * Two pass method
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode temp = head;
        /**
         * get the size so that we can remove from beginning
         * */
        int size = getSize(head);

        /** if the size is same as the n , meaning removing the head.
         * then just return head next
         * */
        if(size == n)
            return head.next;

        int m = size - n , counter = 1;

        while ( counter < m && temp!= null){
            temp = temp.next;
            counter++;
        }

        temp.next = temp.next.next ;
        return head ;
    }

    /**
     * Two pass method
     * */
    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head ;
        ListNode slow = node , fast = node ;
        if (head == null)
            return head;


        int counter = 1;

        while (counter <= n + 1){
            fast = fast.next;
            counter++;
        }

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return node.next ;
    }

    @Test
    public void test_(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.setNext(n2).setNext(n3).setNext(n4).setNext(n5).setNext(n6);

        removeNthFromEndOnePass(n1 , 3);
    }

    @Test
    public void test_2(){
        ListNode n1 = new ListNode(1);

        removeNthFromEnd(n1 , 1);
    }
}
