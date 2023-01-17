package trees.binary;

/**
 * @author jivanpatil
 * Search the node in given Binary Search Tree
*/
class BinarySearch{

    boolean binarySearch(Node head,int target){

        if (head ==null){
            return false;
        }

        if(head.data == target){
            return true;
        }

        return target < head.data ? binarySearch(head.left, target) : binarySearch(head.right, target);
    }


    boolean binarySearch(int[] ints , int target , int _left , int _right){

        int mid = (_left + _right) /2;

        if (ints[mid] == target)
            return true;

        if (_left == _right)
            return false;

        if ( target < ints[mid])
            _right = mid - 1 ;
        else _left = mid + 1 ;

        return binarySearch(ints , target , _left , _right);
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

//        System.out.println(new BinarySearch().binarySearch(root,8));

        System.out.println(new BinarySearch().binarySearch(new int[]{
                1,3,5,6,8,9,10
        } , 2 , 0 , 7));
    }
}

class Node{
    public int data;
    public Node left;
    public Node right;
    public Node parent;

    Node(int data){
        this.data = data;
    }
}