package lists;


import org.junit.Assert;
import org.junit.Test;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * */
public class RemoveDuplicates {

    /**
     * Function to remove the duplicate elements from list.
     * Given the list is already sorted.
     * @param head head node or current node
     * @return head
     * */
    private Node deleteDuplicates(Node head) {
        if(head == null || head.next == null){
            return head;
        }

        Node current = head;
        while (current.next!=null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            current = current.next;
            if (current == null)
                break;
        }
        return head;
    }

    @Test
    public void test(){
        Assert.assertNull(deleteDuplicates(null));
    }

    @Test
    public void test2(){
        Assert.assertNull(deleteDuplicates(new Node(10).next));
    }

    @Test
    public void test3(){
        Node root = new Node(1);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        root.setNext(n1).setNext(n2).setNext(n3);
        deleteDuplicates(root);
    }

    @Test
    public void test4(){
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(3);

        root.setNext(n1).setNext(n2).setNext(n3);
        deleteDuplicates(root);
    }

    @Test
    public void test5(){
        Node root = new Node(1);
        Node n1 = new Node(1);

        root.setNext(n1);
        deleteDuplicates(root);
    }
}
