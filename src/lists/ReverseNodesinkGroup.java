package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 25. Reverse Nodes in k-Group
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode tail;

        while (prev.next!=null){
            tail = prev.next;
            int count = 0;
            while ( tail!=null && count!=k){
                tail = tail.next;
                count++;
            }

            if (count!= k && tail == null)
                break;

            ListNode[] result = reverseList(prev.next , tail);
            prev.next = result[0];
            result[1].next = tail;
            prev = result[1];
        }

        return dummy.next;
    }

    public ListNode[] reverseList(ListNode head , ListNode tail){
        ListNode prev = null;
        ListNode root = head;
        ListNode newTail = head;

        while (root!=null && root!=tail){

            ListNode temp = root.next;
            ListNode current = root;

            current.next = prev;
            prev = current;
            root = temp;
        }

        return new ListNode[]{prev , newTail};
    }

    @Test
    public void test_(){

        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);

        l2.setNext(l3).setNext(l4).setNext(l5).setNext(l6).setNext(l7);

        reverseKGroup(l2 , 2);
    }

    @Test
    public void test_2(){

        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);

        l2.setNext(l3).setNext(l4).setNext(l5).setNext(l6);

        reverseKGroup(l2 , 2);
    }

    @Test
    public void test_3(){

        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);

        l2.setNext(l3);

        reverseKGroup(l2 , 2);
    }
}
