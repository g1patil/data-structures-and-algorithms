package trees.binary;
/**
 * Find the minimum value in the Binary Tree
 * 
 * 
*/
public class MinimumBinaryTree {

    int findMin(Node heads){
        
        if(heads == null){
            return Integer.MAX_VALUE;
        }

           int left = findMin(heads.left);
           int right = findMin(heads.right);

        return Math.min(Math.min(left, heads.data), Math.min(heads.data, right));
    }
    public static void main(String[] args) {

        //initialize the node
        Node root = new Node(10);
        Node n1 = new Node(65);
        Node n2 = new Node(18);
        Node n3 = new Node(4);
        Node n4 = new Node(18);
        Node n5 = new Node(12);
        Node n6 = new Node(25);
        Node n7 = new Node(6);
        Node n8 = new Node(99);
        Node n9 = new Node(101);



        
        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

        n4.left = n7;
        n4.right = n8;

        n6.left = n9;

        System.out.println(new MinimumBinaryTree().findMin(root));
    }
}