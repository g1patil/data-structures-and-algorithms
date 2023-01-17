package trees.binary;
/**
 * Find the height of the Binary Tree
 * 
 * 
*/
public class HeightOfBinaryTree {

    int getHeight(Node root){
        if(root ==null){
            return -1;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right)+1;
    }
    //Driver class call
    public static void main(String[] args) {
        //initialize the node
        Node root = new Node(100);
        Node n1 = new Node(55);
        Node n2 = new Node(2);
        Node n3 = new Node(14);
        Node n4 = new Node(88);
        Node n5 = new Node(1);
        Node n6 = new Node(5);
        Node n7 = new Node(16);
        Node n8 = new Node(39);
        Node n9 = new Node(7);


        
        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

        n4.left = n7;
        n4.right = n8;

        n8.left = n9;

        System.out.println(new HeightOfBinaryTree().getHeight(root));
    }
}