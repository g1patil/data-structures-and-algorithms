package practice_material.cracking_coding_interview.chapter2;

import org.junit.Test;

/**
 * @auther g1patil
 *
 * Partition the linked list in a way the all the nods lesser than
 * target number are on the left side and all the nodes greater than
 * are on the right side.
 */
public class PartitionList {

    /**
     * Appends the two lists.
     * @param n1 head of the first list
     * @param n2 head of the second node
     * @return returns the head of the merged lists
     * */
    private Node appendNode(Node n1 , Node n2){
        if (n1 == null)
            return n2;

        if (n2== null)
            return n1;

        Node temp = n1 ;
        while (temp.next != null)
            temp = temp.next;
        temp.next = n2 ;
        return n1 ;
    }

    /**
     * @param root head of the list , root node
     * @param targetNumber target number for comparison
     * @return returns the sorted list such that all the smaller elements are on one side
     * and all the greater element are on the other side.
     * */
    private Node partitionList(Node root , final int targetNumber){
        if (root == null || root.next == null)
            return root;

        /*  p1 will keep list nodes which are smaller than target
         p2 will keep the nodes which are greater that target*/
        Node p1 = null , p2 = null ;

        //create dummy node so that we always have the track of the previous node.
        Node dummyNode = new Node(0);
        dummyNode.setNext(root);

        //now create the pointer on the dummy node
        Node pointer = dummyNode ;

        /*
        iterate over list using the next element always.
        iterating on the next element gives the ability to swap easily.
        * */
        while ( pointer.next != null){
            if (pointer.next.data < targetNumber){
                Node temp = pointer.next ;
                pointer.next = pointer.next.next;
                temp.next = null ;
                p1 = appendNode(p1 , temp );

            } else {
                Node temp = pointer.next ;
                pointer.next = pointer.next.next;
                temp.next = null ;
                p2 = appendNode(p2 , temp );
            }
        }

        //append the p2 at the end of the p1
        return appendNode(p1,p2);
    }

    @Test
    public void test_(){
        Node n1 = new Node(3);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        Node n4 = new Node(5);
        Node n5 = new Node(10);
        Node n6 = new Node(2);
        Node n7 = new Node(1);

        n1.setNext(n2).setNext(n3).setNext(n4).setNext(n5).setNext(n6).setNext(n7);
        System.out.println("--------- test 1 ------------");
        n1.printList();
        System.out.println();
        partitionList(n1 , 5 ).printList();

    }

    @Test
    public void test_2(){
        Node n1 = new Node(3);
        System.out.println("--------- test 2 ------------");
        n1.printList();
        System.out.println();
        partitionList(n1 , 5 ).printList();

    }

    @Test
    public void test_3(){
        System.out.println("--------- test 3 ------------");
        partitionList(null , 5 );

    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public Node setNext(Node next){
        this.next = next;
        return next;
    }

    public int size(final Node node){
        int size = 0;
        if (node == null){
            return 0;
        }
        Node temp = node ;
        while (temp!=null){
            size ++;
            temp = temp.next;
        }
        return size;
    }

    public void printList(){
        Node p1 = this ;

        while (p1 != null){
            System.out.print( p1.data + " -> ");
            p1 = p1.next ;
        }
        System.out.print( "null" );
    }
}
