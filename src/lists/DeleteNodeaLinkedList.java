package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 237. Delete Node in a Linked List
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class DeleteNodeaLinkedList {

    public void deleteNode(ListNode node) {
        ListNode temp = node;

        while(temp !=null && temp.next != null){
            temp.val = temp.next.val;
            if(temp.next.next == null){
                temp.next = null;
            }
            temp = temp.next;
        }
    }

    @Test
    public void test(){
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(10);

        n1.setNext(n2).setNext(n3).setNext(n4);
        deleteNode(n3);
        n1.printList();
    }
}
