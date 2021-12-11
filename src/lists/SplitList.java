package lists;

import org.junit.jupiter.api.Test;

/**
 * Split the linked list in two lists , such that all even positions are in one list,
 * and rest are in other. Alternatively, split the list in two lists such that two
 * successive elements are in different lists.
 *
 * */
public class SplitList {


    /**
     * Splits the list in two different lists and prints it.
     * @param root  root node of the given list
     * */
    private void splitList(Node root){
        Node odd = root;

        Node p1 = root;
        Node p2 = root.next;

        while ( p1 != null || p2 !=null){
            Node temp = p2.next;
            if ( temp == null)
                break;
            p1.next = temp ;
            p2.next = temp.next;
            p1 = temp ;
            p2 = temp.next;
        }

        while (odd != null){
            System.out.println( odd.data);
            odd = odd.next;
        }
    }

    @Test
    public void test(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.setNext( n2 );
        n2.setNext( n3 );
        n3.setNext( n4 );
        n4.setNext( n5 );
        n5.setNext( n6 );

        this.splitList( n1 );
    }
}
