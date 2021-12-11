package practice_material.cracking_coding_interview.chapter2;

import lists.ListNode;
import org.junit.Test;

/**
 * @author g1patil
 */
public class RemoveMiddleNode {

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
        deleteMiddleNode(n1).printList();

    }

    @Test
    public void test_2(){
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(8);


        n1.setNext(n2).setNext(n3);
        n1.printList();
        System.out.println();
        deleteMiddleNode(n1).printList();

    }

    @Test
    public void test_3(){
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);


        n1.setNext(n2);
        n1.printList();
        System.out.println();
        deleteMiddleNode(n1).printList();

    }

    private ListNode deleteMiddleNode(ListNode n1) {
        if (n1 == null)
            throw new IllegalArgumentException("Provided list is null");

        ListNode p1 = n1 ;
        ListNode p2 = n1.next;

        if (n1.size() < 3 )
            throw new IllegalArgumentException("Size of the list should be greater that 3");

        while (p2.next != null){
            p1 = p1.next ;
            p2 = p2.next.next;

            if (p2 == null)
                break;
        }

        p2 = n1;

        while (p2.next != p1){
            p2 = p2.next;
        }

        p2.next = p1.next;
        return n1;
    }
}
