package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 160. Intersection of Two Linked Lists
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0 , sizeB = 0;

        ListNode temp = headA;
        while(temp!=null){
            sizeA++;
            temp = temp.next;
        }

        temp = headB;

        while(temp!=null){
            sizeB++;
            temp = temp.next;
        }

        if(sizeA > sizeB){
            while(sizeA !=sizeB){
                headA = headA.next;
                sizeA--;
            }
        } else {
            while(sizeA !=sizeB){
                headB = headB.next;
                sizeB--;
            }
        }

        while(headA !=headB ){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }
}
