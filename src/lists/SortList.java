package lists;

import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;

/***
 * Sort the linked list
 */
public class SortList {

//TODO this is incomplete

    public static void main(String[] args) {
        SortList sortList = new SortList();

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(11);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode head = node1;


    }
}

class ListNode{
    public int data;
    public ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}