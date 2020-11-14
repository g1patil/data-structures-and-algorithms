package lists;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null. There is a cycle in a linked list if there is some node
 * in the list that can be reached again by continuously following the next
 * pointer. Internally, pos is used to denote the index of the node that tail's
 * next pointer is connected to. Note that pos is not passed as a parameter.
 * Notice that you should not modify the linked list. Follow up: Can you solve
 * it using O(1) (i.e. constant) memory?
 * 
 * 
 */
public class LinkedListCycle {

    public static Node getIndexOfCycle(List<Node> input){
        Map<Node,Node> mapOfNodes= new HashMap<>();
        
        for(Node node : input){
            mapOfNodes.put(node, null);
            if(mapOfNodes.containsKey(node.next)){
                return node.next;

            }      
        }
        return null;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node5.next = node4; 
        

        System.out.println(
            getIndexOfCycle(List.of(node1,node2,node3,node4,node5)).data
        );
    }
    
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}