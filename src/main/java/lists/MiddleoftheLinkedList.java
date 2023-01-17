package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 876. Middle of the Linked List
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MiddleoftheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;

            if(fast!=null)
                fast = fast.next;
        }
        return slow;
    }
}
