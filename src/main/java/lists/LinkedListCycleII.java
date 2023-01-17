package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 142. Linked List Cycle II
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return head;

        ListNode collNode = getCollisionNode(head);
        if (collNode == null)
            return null;
        ListNode tempHead = head ;

        while (collNode !=tempHead){
            collNode = collNode.next;
            tempHead = tempHead.next;
        }

        return collNode;
    }

    private ListNode getCollisionNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return slow;
        }
        return null;
    }
}
