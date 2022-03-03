package lists;

import annotation.Pattern;
import annotation.Platform;
import annotation.Quality;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * You are given a singly-linked list that contains N integers.
 * A subpart of the list is a contiguous set of even elements, bordered either by either end of the list or an odd element.
 * For example, if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
 * Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
 * The goal of this question is: given a resulting list, determine the original order of the elements.
 */
@Quality(Stage.TESTED)
public class ReverseOperations {

    Node reverse(Node head) {
        Node dummy = new Node(-1);
        dummy.next  = head;
        Node root = dummy;

        while (root!=null){
            while (root.next.data %2 != 0)
                root = root.next;

            Node first = root.next;
            Node last = getFirstEven(first);
            Node lastNext = last.next;

            Node[] reversed = reverseList(first, last);
            root.next = reversed[0];
            reversed[1].next = lastNext;
            root = lastNext;
        }

        return dummy.next;
    }
    Node getFirstEven(Node head){
        Node even = head;
        while (even.next!=null && even.next.data % 2 ==0 )
            even = even.next;
        return even;
    }

    Node[] reverseList(Node head,Node tail){
        Node reverse = null;
        Node root = head;

        while(root != tail){
            Node temp = root.next;
            root.next = reverse;
            reverse = root;
            root = temp;
        }
        root.next = reverse;
        reverse = root;
        return new Node[]{reverse , head};
    }

    @Test
    public void test_(){
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(7);
        Node n5 = new Node(8);
        Node n6 = new Node(10);
        Node n7 = new Node(12);
        n2.setNext(n3).setNext(n4).setNext(n5).setNext(n6).setNext(n7);
        reverse(n2);
    }
}
