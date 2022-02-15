package lists;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class InsertIntoSortedCircularLinkedList {

    public Node insert(Node head, int insertVal) {
        if (head == null){
            Node node = new Node(insertVal);
            head.next = node;
            return node;
        }

        Node previous = head;
        Node next = head.next;

        if (previous == next){
            Node node = new Node(insertVal);
            head.next = node;
            node.next = head;
            return node;
        }
        while (next.data > insertVal && next !=head ){
            next = next.next;
            previous = previous.next ;
        }

        while (next.data < insertVal && next!=head){
            next = next.next;
            previous = previous.next;
        }


        Node node = new Node(insertVal);
        previous.next = node;
        node.next = next;

        return node;
    }

    @Test
    public void test_(){
        Node n1 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(1);
        n1.setNext(n3).setNext(n4);
        n4.setNext(n1);

        insert(n1 , 2 );
    }

    @Test
    public void test_2(){
        Node n1 = new Node(3);
        n1.setNext(n1);
        insert(n1 , 2 );
    }

    @Test
    public void test_3(){
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        n1.setNext(n1).setNext(n2).setNext(n3).setNext(n1);
        insert(n1 , 2);
    }
}
