package lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseList {

    /**
     * Reverses the singly linked list
     * @param root node of the head
     * */
    private Node reverseList(Node root){
        Node previous = null;
        Node current = root;

        while (current!=null){
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    /**
     * Reverse the circular linked list
     * @param node current or any node
     * @return any pointer
     * */
    private Node reverseCircular(Node node){
        Node current = node;
        Node next = node.next;

        while (next!=node){
            Node temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        //adjust the last node
        next.next = current;
        return next;
    }

    @Test
    public void test1(){
        Node n1 = new Node(4);
        Node n2 = new Node(5);
        Node n3 = new Node(6);
        Node n4 = new Node(7);
        Node n5 = new Node(8);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n1;

        Assertions.assertNotNull(reverseCircular(n1));
    }
}
