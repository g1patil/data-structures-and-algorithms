package practice_material.cracking_coding_interview.chapter2;

import lists.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * Delete the kth node from the last
 */
public class RemoveKthNode {

    @Test
    public void test_(){
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(10);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(1);

        n1.setNext(n2).setNext(n3).setNext(n4).setNext(n5).setNext(n6).setNext(n7);
        n1.printList();
        System.out.println();
        deleteKthNode(n1 , 7 ).printList();

    }

    private ListNode deleteKthNode(ListNode n1, int i) {
        final int size = n1.size();
        if (i > size)
            throw new IllegalArgumentException("The size of the list is smaller than target position");

        if (i == size)
            return n1.next;

        int index = 1;

        ListNode temp = n1 ;
        while (index != (size - i) ){
            temp = temp.next ;
            index ++ ;
        }

        // remove the node. n1 -> n2 -> n3 ==> n1 -> n2
        temp.next = temp.next.next;
        return n1 ;
    }
}
