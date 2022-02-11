package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author g1patil
 * 24. Swap Nodes in Pairs
 * Algo : maintain the previous
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SwapNodesPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (head!=null && head.next!=null){

            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            head = first.next;
        }
        return dummy.next;
    }

    public ListNode swap(ListNode one){
        ListNode first = one;
        ListNode second = one.next;

        first.next = second.next;
        second.next = first;
        return second;
    }

    @Test
    public void test_(){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);

        l1.setNext(l2).setNext(l3).setNext(l4);

        swapPairs(l1);
    }

}
