package trees.binary;

/*
* Print the sum of all the possible paths from root to leaf
* */
public class PathSum {

    public void calculateSum(Node node, int sum){

        if (node.left == null && node.right == null){
            System.out.println(sum + node.data);
            return;
        }

        if(node.left !=null){
            calculateSum(node.left,sum + node.data);
        }
        if(node.right !=null){
            calculateSum(node.right,sum + node.data);
        }

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node n1 = new Node(5);
        Node n2 = new Node(20);
        Node n3 = new Node(4);
        Node n4 = new Node(8);
        Node n5 = new Node(14);
        Node n6 = new Node(25);
        Node n7 = new Node(6);
        Node n8 = new Node(9);
        Node n9 = new Node(30);





        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.left = n5;
        n2.right = n6;

        n4.left = n7;
        n4.right = n8;

        n6.right = n9;

        new PathSum().calculateSum(root,0);
    }
}
