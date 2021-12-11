package lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.management.relation.InvalidRelationIdException;

/*
* 203. Remove Linked List Elements
*
* Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*
* */
public class RemoveLinkedListElement {

    public Node removeElements(Node head, int val) {

        if(head == null){
            return null;
        }

        if(head.data == val){
            return head.next;
        }

        Node previous = head;
        Node next = previous.next;

        while (next!=null){
            if(next.data == val){
                previous.next = next.next;
                break;
            } else {
                next = next.next;
                previous = previous.next;
            }
        }
        return head;
    }

    @Test
    public void test(){
        Assertions.assertNull(removeElements(null,9));
    }

    @Test
    public void test2(){
        Node head = new Node(5);
        Assertions.assertNotNull(removeElements(head,9));
    }

    @Test
    public void test3(){
        Node head = new Node(5);
        Node n2 = new Node(6);
        Node n3 = new Node(7);
        head.setNext(n2).setNext(n3);

        removeElements(head,6);
    }
}
