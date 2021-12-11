package lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * Remove the duplicates from unsorted linked list
 * Node is duplicate if the value of that node already exist.
 *
 * */
public class RemoveDuplicatesUnsortedList {

    /**
     * Function to remove the duplicates from the unsorted list
     * @param head head node
     * @return head with duplicates removed
     * */
    private Node deleteDuplicates(Node head){

        // Edge case of null and single node
        if(head == null || head.next == null){
            return head;
        }

        Node current = head;
        Node previous = null;

        Map<Integer,Integer> integerMap = new HashMap<>();

        while (current!=null){
            if(integerMap.containsKey(current.data)){
                previous.next = current.next;
            } else {
                integerMap.put(current.data, current.data);
                previous = current;
            }

            current = current.next;
        }

        return head;
    }

    //null node
    @Test
    public void test(){
        Assertions.assertNull(deleteDuplicates(null));
    }

    //single node
    @Test
    public void test2(){
        Assertions.assertNull(deleteDuplicates(new Node(10)).next);
    }

    //duplicate at beginning
    @Test
    public void test3(){
        Node root = new Node(2);
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(3);

        root.setNext(n1).setNext(n2).setNext(n3);
        deleteDuplicates(root);
    }

    //only two nodes, duplicate
    @Test
    public void test4(){
        Node root = new Node(2);
        Node n1 = new Node(2);

        root.setNext(n1);
        deleteDuplicates(root);
    }

    // Last two nodes duplicate
    @Test
    public void test5(){
        Node root = new Node(2);
        Node n1 = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(3);
        Node n4 = new Node(3);

        root.setNext(n1).setNext(n2).setNext(n3).setNext(n4);
        deleteDuplicates(root);
    }

    //Multiple nodes duplicate
    @Test
    public void test6(){
        Node root = new Node(2);
        Node n1 = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(3);

        root.setNext(n1).setNext(n2).setNext(n3).setNext(n4).setNext(n5);
        deleteDuplicates(root);
    }
}
