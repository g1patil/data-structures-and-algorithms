package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;

/***
 * Sort the linked list
 * @author g1patil
 * 148. Sort List
 *
 * Algo :
 * Call the merge sort on the list.
 * split the list in two half
 * recusrsively call the merge sort on both split until length of the split is 1
 * make sure to assign them back to theirself
 * then merge the two sorted lists
 *
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SortList {


    /**
     * Merges the two sorted linked lists
     * */
    public ListNode mergeTwoList(ListNode one, ListNode two){
        if (one == null || two == null)
            return one == null ? two : one;

        ListNode result = new ListNode(0);
        ListNode head = result;

        while (one!=null && two!=null){
            if (one.val < two.val){
                head.next = one ;
                one = one.next ;
            } else {
                head.next = two;
                two = two.next;
            }
            head.next.next = null;
            head = head.next;

        }

        if (one!=null){
            head.next = one ;
        } else {
            head.next = two ;
        }

        return result.next ;
    }
    public ListNode sortList(ListNode head) {
        return mergeSortList(head);
    }

    private ListNode mergeSortList(ListNode head) {

        //divide the list
        ListNode[] split = splitList(head);

        if (split.length!= 1){
            split[0] = mergeSortList(split[0]);
            split[1] = mergeSortList(split[1]);
        }

        return mergeTwoList(split[0] , split.length == 1 ? null : split[1]);
    }

    /**
     * Split the two linked lists in two equal parts
     * */
    private ListNode[] splitList(ListNode head) {
        if (head == null ||head.next == null)
            return new ListNode[]{head};

        ListNode headCopy = head ;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast!=null)
            slow = slow.next;

        ListNode temp = headCopy;
        while (temp.next!=slow)
            temp = temp.next;
        temp.next = null;

        ListNode[] sorted = new ListNode[2];

        sorted[0] = headCopy;
        sorted[1] = slow ;

        return sorted;
    }

    @Test
    public void test_(){
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);

        n1.setNext(n2).setNext(n3);
        n1 = sortList(n1);
        System.out.println(n1.val);
    }

}
