package trees.binary;
/**
 * Find the maximum element in the Binary Search Tree
 * 
 * 
*/
public class MaximuminTree {

    int findMax(Node head){
        if(head == null){
            return -1;
        }

        if(head.right !=null){
            return findMax(head.right);
        }

        return head.data;
    }
    public static void main(String[] args) {
        //initialize the node
        Node root = new Node(10);
        Node n1 = new Node(5);
        Node n2 = new Node(20);
        Node n3 = new Node(4);
        Node n4 = new Node(8);
        Node n5 = new Node(14);
        Node n6 = new Node(25);
        Node n7 = new Node(6);
        Node n8 = new Node(9);


        
        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

        n4.left = n7;
        n4.right = n8;

        System.out.println(new MaximuminTree().findMax(root));
    }
}