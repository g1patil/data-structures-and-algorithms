package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 23. Merge k Sorted Lists
 * Algo :
 *  0,1,2,3,4,5,6,7
 *  merge each adj first
 *  then 0,2,4,6
 *      0,2 and 4,6
 *      then 0 ,4
 *
 *  interval loop is really important
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MergekSortedLists {


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        int interval = 1 ;
        while (interval < lists.length){
            for (int i = 0; i < lists.length; i+=interval*2) {
                lists[i] = mergeTwoList(lists[i] , lists[i + interval]);
            }
            interval*=2;
        }
        return lists[0];
    }

    public ListNode mergeTwoList(ListNode one , ListNode two){
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (one!=null && two != null){
            if (one.val < two.val){
                head.next = one;
                one = one.next;
                head = head.next;
            } else {
                head.next = two;
                two = two.next;
                head = head.next;
            }
        }
        if (one!=null)
            head.next = one;
        if (two!=null)
            head.next = two;
        return dummy.next;
    }

    @Test
    public void test_(){

    }

}
