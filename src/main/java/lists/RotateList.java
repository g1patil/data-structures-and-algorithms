package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 61. Rotate List
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null ){
            return head;
        }
        int  size = getSize(head);
        k = k > size ? k % size : k ;
        for(int i = 0; i < k; i++) {
            ListNode[] last = getLastTwo(head);
            head = moveLastToHead(head , last[0], last[1] );
        }
        return head;
    }

    private ListNode[] getLastTwo(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head.next;

        while(p2.next != null && p1 !=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return new ListNode[]{p1,p2};
    }

    public ListNode moveLastToHead(ListNode head , ListNode previous , ListNode last){
        ListNode tempHead = last;
        tempHead.next = head;
        previous.next = null;
        return tempHead;

    }

    public int getSize(ListNode head){
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            temp =  temp.next;
            size++;
        }
        return size;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);

        l1.setNext(l2);
        rotateRight(l1,5);

    }
}
