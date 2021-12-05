package practice_material.cracking_coding_interview.chapter2;

import lists.ListNode;
import org.junit.Test;

/**
 * @auther g1patil
 *
 * Partition the linked list in a way the all the nods lesser than
 * target number are on the left side and all the ListNodes greater than
 * are on the right side.
 */
public class PartitionList {

    /**
     * Appends the two lists.
     * @param n1 head of the first list
     * @param n2 head of the second ListNode
     * @return returns the head of the merged lists
     * */
    private ListNode appendListNode(ListNode n1 , ListNode n2){
        if (n1 == null)
            return n2;

        if (n2== null)
            return n1;

        ListNode temp = n1 ;
        while (temp.next != null)
            temp = temp.next;
        temp.next = n2 ;
        return n1 ;
    }

    /**
     * @param root head of the list , root ListNode
     * @param targetNumber target number for comparison
     * @return returns the sorted list such that all the smaller elements are on one side
     * and all the greater element are on the other side.
     * */
    private ListNode partitionList(ListNode root , final int targetNumber){
        if (root == null || root.next == null)
            return root;

        /*  p1 will keep list ListNodes which are smaller than target
         p2 will keep the ListNodes which are greater that target*/
        ListNode p1 = null , p2 = null ;

        //create dummy ListNode so that we always have the track of the previous ListNode.
        ListNode dummyListNode = new ListNode(0);
        dummyListNode.setNext(root);

        //now create the pointer on the dummy ListNode
        ListNode pointer = dummyListNode ;

        /*
        iterate over list using the next element always.
        iterating on the next element gives the ability to swap easily.
        * */
        while ( pointer.next != null){
            if (pointer.next.data < targetNumber){
                ListNode temp = pointer.next ;
                pointer.next = pointer.next.next;
                temp.next = null ;
                p1 = appendListNode(p1 , temp );

            } else {
                ListNode temp = pointer.next ;
                pointer.next = pointer.next.next;
                temp.next = null ;
                p2 = appendListNode(p2 , temp );
            }
        }

        //append the p2 at the end of the p1
        return appendListNode(p1,p2);
    }

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
        System.out.println("--------- test 1 ------------");
        n1.printList();
        System.out.println();
        partitionList(n1 , 5 ).printList();

    }

    @Test
    public void test_2(){
        ListNode n1 = new ListNode(3);
        System.out.println("--------- test 2 ------------");
        n1.printList();
        System.out.println();
        partitionList(n1 , 5 ).printList();

    }

    @Test
    public void test_3(){
        System.out.println("--------- test 3 ------------");
        partitionList(null , 5 );
    }
}
