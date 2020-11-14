package trees.binary;

/**
 * Search the node in given Binary Search Tree
 * 
 * 
*/
class BinarySearch{



    boolean binarySearch(Node head,int target){

        if (head ==null){
            System.out.println("The tree node is null");
            return false;
        }

        if(head.data == target){
            return true;
        }

        if (target < head.data  && head.left!=null){
            return binarySearch(head.left, target);
        }

        if(target> head.data  && head.right!=null){
            return binarySearch(head.right, target);
        }

        return false;
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

        System.out.println(new BinarySearch().binarySearch(root,8));
    }
}

class Node{
    public int data;
    public Node left;
    public Node right;

    Node(int data){
        this.data = data;
    }
}