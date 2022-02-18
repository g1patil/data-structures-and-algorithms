package practice_material.cracking_coding_interview.chapter2;

import lists.ListNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 */
public class ListIntersection {

    // this is linear space and time complexity solution.
    private ListNode getIntersectionNode(ListNode n1 , ListNode m1){
        Map<ListNode , Integer> nodeIntegerMap = new HashMap<>();

        ListNode temp = n1 ;

        while ( temp != null){
            nodeIntegerMap.put( temp , 1  );
            temp  = temp.next ;
        }

        temp = m1 ;

        while ( temp != null ){
            if ( nodeIntegerMap.containsKey(temp)){
                return temp ;
            }
            temp = temp.next ;
        }

        return new ListNode(-1);
    }

    //this will give the constant performace
    private ListNode getIntersectionNodeOptimal(ListNode n1 , ListNode m1){
        int nSize = 0;
        int mSize = 0;

        ListNode n = n1;
        while ( n!=null){
            n = n.next;
            nSize++;
        }
        n = m1;
        while ( n!=null){
            n = n.next;
            mSize++;
        }

        if (nSize > mSize){
            while (nSize!=mSize){
                n1 = n1.next;
                nSize--;
            }
        } else {
            while (nSize!=mSize){
                n1 = n1.next;
                nSize--;
            }
        }
        return null;
    }

    private void rotate(ListNode n1){
        ListNode p1 = n1 , p2 = n1.next ;

        while ( p1 != p2){
            p1 = p1.next ;
            p2 = p2.next.next;
        }

        System.out.println("Collide at " + p1.val);
    }

    @Test
    public void test_(){
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(6);

        ListNode m1 = new ListNode(8);

        n1.setNext(n2).setNext(n3).setNext(n4);
        m1.setNext(n4);

        n1.printList();
        System.out.println();
        m1.printList();

        System.out.println();
        getIntersectionNode(n1 , m1 ).printList();

    }

    @Test
    public void test_2(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);

        n9.setNext(n4);

        n1.setNext(n2).setNext(n3).setNext(n4).setNext(n5).setNext(n6).setNext(n7).setNext(n8).setNext(n9);

        this.rotate(n1);

    }
}
