package lists;
import org.junit.jupiter.api.Test;

/**
 * 21. Merge Two Sorted Lists
 *
 * Easy
 *
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 *
 * */
public class MergeTwoSortedLists {

    /**
     * @param l1 list one - sorted
     * @param l2 list two - sorted
     * @return merged sorted list
     * */
    public Node mergeTwoLists(Node l1, Node l2) {
        Node result = new Node(0);
        Node current = result;

        while (l1!=null && l2!=null){
            if (l1.data < l2.data){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1 != null){
            current.next = l1;
        } else {
            current.next = l2;
        }
        return result.next;
    }

    @Test
    public void test(){
        Node n1 = new Node(1);
        Node n2 = new Node(5);
        Node n3 = new Node(9);

        n1.setNext(n2).setNext(n3);

        Node l1 = new Node(2);
        Node l2 = new Node(7);
        Node l3 = new Node(11);

        l1.setNext(l2).setNext(l3);

        Node result = mergeTwoLists(n1,l1);
    }

    @Test
    public void test2(){
        Node result = mergeTwoLists(null,null);
    }

    @Test
    public void test3(){
        Node n1 = new Node(1);
        Node result = mergeTwoLists(n1,null);
    }

    @Test
    public void test4(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(9);

        n1.setNext(n2).setNext(n3);

        Node l1 = new Node(2);
        Node l2 = new Node(7);
        Node l3 = new Node(9);

        l1.setNext(l2).setNext(l3);

        Node result = mergeTwoLists(n1,l1);
    }
}
