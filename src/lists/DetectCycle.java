package lists;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

/**
 * @author jivanpatil
 * Check if there is clycle in the linked list
 * */
public class DetectCycle {

    /**
     * @param node head node
     * Space O(n)
     *  Linear
     * */
    private boolean cycleExist(Node node){
        Hashtable<Node,Node> nodes = new Hashtable<>();
        while (node!=null){
            if(!nodes.containsKey(node)){
                nodes.put(node,node);
            } else {
                return true;
            }

            node = node.next;

        }
        return false;
    }

    /**
     * Two pointer method
     * Space O(1)
     * */
    private boolean detectCycle(Node node){
        if(node == null){
            return false;
        }

        Node odd = node;
        Node even = node.next;

        while (odd != even){

            if(even == null || even.next == null){
                return false;
            }

            odd = odd.next;
            even = even.next.next;
        }

        return true;
    }

    @Test
    public void test1(){
        Node n1 = new Node(4);
        Assertions.assertFalse(detectCycle(n1));
    }

    @Test
    public void test2(){
        Node n1 = new Node(4);
        Node n2 = new Node(5);
        n1.next = n2 ;
        Assertions.assertFalse(detectCycle(n1));
    }

    @Test
    public void test3(){
        Node n1 = new Node(4);
        Node n2 = new Node(5);
        n1.next = n2 ;
        n2.next = n1 ;
        Assertions.assertTrue(detectCycle(n1));
    }

    @Test
    public void test4(){
        Node n1 = new Node(4);
        Node n2 = new Node(5);
        Node n3 = new Node(6);
        Node n4 = new Node(7);
        Node n5 = new Node(8);
        n1.next = n2 ;
        n2.next = n3 ;
        n3.next = n4 ;
        n4.next = n5 ;
        n5.next = n3 ;

        Assertions.assertTrue(detectCycle(n1));
    }

    @Test
    public void cycleExist(){
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

        Assertions.assertTrue(cycleExist(n1));
    }

    @Test
    public void cycleInMiddle(){

        Node n1 = new Node(4);
        Node n2 = new Node(5);
        Node n3 = new Node(6);
        Node n4 = new Node(7);
        Node n5 = new Node(8);
        Node n6 = new Node(4);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Assertions.assertTrue(cycleExist(n1));

    }
}
