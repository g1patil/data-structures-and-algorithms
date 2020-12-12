package trees.binary;

/**
 * Algorithm to delete the node from the BST
 * 
*/
public class DeleteNodeInBST {
    
    Node findNode(Node current,int target){
        if(current == null){
            return null;
        }

        if(current.data == target){
            return current;
        }

        if(target < current.data){
            return findNode(current.left, target);
        } else {
            return findNode(current.right, target);
        }
    }
    public static void main(String[] args) {
        //initialize the node
                Node root = new Node(10);
                Node n1 = new Node(5);
                Node n2 = new Node(20);

                // Node n3 = new Node(4);
                // Node n4 = new Node(8);
                // Node n5 = new Node(14);
                // Node n6 = new Node(25);
                // Node n7 = new Node(6);
                // Node n8 = new Node(9);
        
        
                
                root.left = n1;
                root.right = n2;
        
                // n1.left = n3;
                // n1.right = n4;
        
                // n2.left = n5;
                // n2.right = n6;
        
                // n4.left = n7;
                // n4.right = n8;

        DeleteNodeInBST deleteNodeInBST = new DeleteNodeInBST();

        Node targetNode = deleteNodeInBST.findNode(root, 5);
        targetNode = null;
        System.out.println();
    }

    private Node findLowest(Node node) {
        while(node.right !=null){
            node = node.left;
        }
        return node;
    }
}