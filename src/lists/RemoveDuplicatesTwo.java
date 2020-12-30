package lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 82. Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Return the linked list sorted as well.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 * */
public class RemoveDuplicatesTwo {

    /**
     * Returns the unique elements from list
     * @param head head node
     * @return head node with unique elements
     * */
    private Node getUnique(Node head){

        Node p1 = head;

        Map<Integer,Integer> map = new HashMap<>();

        while ( p1 != null){
            map.put(p1.data, map.getOrDefault(p1.data,0) + 1);
            p1 = p1.next;
        }

        //reset the pointer to head
        p1 = head;
        Node current = new Node(0);
        Node result = current;

        while ( p1 != null){
            if(map.get(p1.data)!=1){
                p1 = p1.next;
            } else {
                current.next = p1;
                p1 = p1.next;
                current = current.next;
                current.next = null;

            }
        }
        return result.next;
    }

    @Test
    public void test(){
        Assert.assertNull(getUnique(null));
    }

    @Test
    public void test2(){
        Assert.assertNull(getUnique(new Node(10)).next);
    }

    @Test
    public void test3(){
        Node root = new Node(10);
        Node n1 = new Node(1);
        Node n2 = new Node(10);
        root.setNext(n1).setNext(n2);

        Node result = getUnique(root);
        Assert.assertNotNull(result);
        Assert.assertNull(result.next);
        Assert.assertEquals(n1.data,result.data);
    }

    @Test
    public void test4(){
        Node root = new Node(10);
        Node n1 = new Node(1);
        Node n2 = new Node(10);
        Node n3 = new Node(2);
        Node n4 = new Node(1);
        Node n5 = new Node(4);
        Node n6 = new Node(5);
        Node n7 = new Node(5);

        root.setNext(n1).setNext(n2).setNext(n3).setNext(n4).setNext(n5).setNext(n6).setNext(n7);

        Node result = getUnique(root);

    }
}
