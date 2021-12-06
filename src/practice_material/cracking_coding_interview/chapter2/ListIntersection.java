package practice_material.cracking_coding_interview.chapter2;

import lists.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther g1patil
 */
public class ListIntersection {

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
}
