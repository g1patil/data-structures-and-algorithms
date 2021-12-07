package practice_material.cracking_coding_interview.chapter2;

import lists.ListNode;
import org.junit.Test;

/**
 * @auther g1patil
 */
public class SumLists {

    /**
     * Adds the carry to the remainder of the list or number you can say.
     * Can be added from any point of the node from the list.
     * @param n1 root node from which addition will start. Will carry on based on the final outcome
     * @param data_ carry that needs to be added from staring node n1
     * @return root node with updated sum
     * */
    private ListNode addCarryToNode(ListNode n1, int data_){
        if (data_ == 0)
            return n1;

        ListNode temp = n1;

        while (temp!=null){
            data_ = temp.data + data_ ;
            if (data_ > 9){
                int remainder = data_ % 10 ;
                data_ = data_ / 10;
                temp.setData( remainder );
            } else {
                temp.setData(data_);
                break;
            }
            if (temp.next == null && data_!= 0 ){
                temp.next = new ListNode(data_);
                break;
            }
            temp = temp.next;
        }

        return n1 ;
    }

    /**
     * Adds the two numbers represented as the linked list in reverse order.
     * @param n1 root node of the first number
     * @param m1 root node of the second number
     * @return final new number represented as the linkedlist
     * */
    private ListNode sumList(ListNode n1 , ListNode m1){
        if (n1 == null)
            return m1;

        if (m1 == null)
            return n1;

        ListNode p1 = n1 , p2 = m1;
        ListNode result = new ListNode(-1);
        ListNode temp = result;

        int carry = 0 ;

        while ( p1 != null && p2 != null){
            int data = p1.data + p2.data + carry ;
            if ( data > 9){
                int remainder = data % 10 ;
                carry = data / 10 ;
                result.next = new ListNode(remainder);
            } else {
                result.next = new ListNode( data );
            }

            p1 = p1.next ;
            p2 = p2.next ;

            result = result.next;
            if ( data < 10)
                carry = 0 ;
        }

        if (p1!=null)
            result.setNext(addCarryToNode(p1, carry));

        if (p2!=null)
            result.setNext(addCarryToNode(p2, carry));

        if (p1 == null && p2 == null && carry > 0){
            result.setNext(new ListNode(carry));
        }

        return temp.next ;
    }

    @Test
    public void test_(){
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(7);

        ListNode m1 = new ListNode(8);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(6);

        n1.setNext(n2).setNext(n3);
        m1.setNext(m2).setNext(m3);

        n1.printList();
        System.out.println();
        m1.printList();

        System.out.println();
        sumList(n1 , m1 ).printList();

    }

    @Test
    public void test_2(){
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);

        n1.setNext(n2).setNext(n3);
        ListNode m1 = new ListNode(1);

        n1.printList();
        System.out.println();

        sumList(n1 , m1 ).printList();

    }

    /**
     * 9->9->9->9->9->9->null
     * 9->9-
     *
     *  999999
     *  +   99
     *  ------
     *  1000098
     *
     *  Result : 8->9->0->0->0->0->1
     * */
    @Test
    public void test_3(){
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);

        n1.setNext(n2).setNext(n3).setNext(n4).setNext(n5).setNext(n6);

        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(9);

        m1.setNext(m2);

        n1.printList();
        System.out.println();

        sumList(m1 , n1 ).printList();

    }

    @Test
    public void test_4(){
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);

        n1.setNext(n2).setNext(n3);

        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(9);

        m1.setNext(m2).setNext(m3);

        n1.printList();
        System.out.println();

        sumList(m1 , n1 ).printList();



    }

    @Test
    public void test_5(){
        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);

        n1.setNext(n2).setNext(n3);

        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(1);

        m1.setNext(m2).setNext(m3);

        n1.printList();
        System.out.println();

        sumList(m1 , n1 ).printList();



    }


}
